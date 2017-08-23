package com.tree.www.zk.cache;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by pysh on 2017/8/23.
 */
public class NodeCacheExample {

    private static final String PATH = "/example/nodeCache";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = null;
        NodeCache cache = null;
        try {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();
            cache = new NodeCache(client, PATH);
            cache.start();
            processCommands(client, cache);
        } finally {
            CloseableUtils.closeQuietly(cache);
            CloseableUtils.closeQuietly(client);
            CloseableUtils.closeQuietly(server);
        }
    }

    private static void processCommands(CuratorFramework client, NodeCache cache) {
        printHelp();
        try {
            addListener(cache);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            boolean done = false;
            while (!done) {
                System.err.print("> ");
                String line = in.readLine();
                if(line == null) {
                    break;
                }
                String command = line.trim();
                String[] parts = command.split("\\s");
                if(parts.length == 0) {
                    continue;
                }
                String operation = parts[0];
                String args[] = Arrays.copyOfRange(parts, 1, parts.length);
                if(operation.equalsIgnoreCase("help") || operation.equalsIgnoreCase("?")) {
                    printHelp();
                } else if(operation.equalsIgnoreCase("q") || operation.equalsIgnoreCase("quit")) {
                    done = true;
                } else if(operation.equals("set")) {
                    setValue(client, command, args);
                } else if(operation.equals("remove")) {
                    remove(client);
                } else if(operation.equals("show")) {
                    show(cache);
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void show(NodeCache cache) {
        if(cache.getCurrentData() != null) {
            System.err.println(cache.getCurrentData().getPath()
                    + " = " + new String(cache.getCurrentData().getData()));
        } else {
            System.err.println("cache don't set value");
        }
    }

    private static void remove(CuratorFramework client) {
        try {
            client.delete().forPath(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setValue(CuratorFramework client, String command, String[] args)
            throws Exception {
        if(args.length != 1) {
            System.err.println("syntax error (expected set <value>):" + command);
            return;
        }
        byte[] bytes = args[0].getBytes();
        try {
            client.setData().forPath(PATH, bytes);
        } catch (Exception e) {
            client.create().creatingParentsIfNeeded().forPath(PATH, bytes);
        }
    }

    private static void printHelp() {
        System.out.println("An example of using PathChildrenCache. This example is driven by entering commands at the prompt:\n");
        System.out.println("set <value>: Adds or updates a node with the given name");
        System.out.println("remove: Deletes the node with the given name");
        System.out.println("show: Display the node's value in the cache");
        System.out.println("quit: Quit the example");
        System.out.println();
    }

    private static void addListener(final NodeCache cache) {
        NodeCacheListener listener = () -> {
            if(cache.getCurrentData() != null) {
                System.err.println("Node changed: " + cache.getCurrentData().getPath()
                        + ",value: " + new String(cache.getCurrentData().getData()));
            }
        };
        cache.getListenable().addListener(listener);
    }
}
