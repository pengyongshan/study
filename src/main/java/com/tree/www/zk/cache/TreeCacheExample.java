package com.tree.www.zk.cache;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.utils.ZKPaths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by pysh on 2017/8/23.
 */
public class TreeCacheExample {
    private static final String PATH = "/example/treeCache";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = null;
        TreeCache cache = null;

        try(TestingServer server = new TestingServer()) {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            cache = new TreeCache(client, PATH);
            cache.start();
            processCommands(client, cache);
        } finally {
            CloseableUtils.closeQuietly(cache);
            CloseableUtils.closeQuietly(client);
        }
    }

    private static void processCommands(CuratorFramework client, TreeCache cache) {
        printHelp();
        try {
            addListener(cache);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            boolean done = false;
            while (!done) {
                System.err.println("> ");
                String line = in.readLine();
                String command = line.trim();
                String[] parts = command.split("\\s");
                if(parts.length == 0) {
                    continue;
                }
                String operation = parts[0];
                String args[] = Arrays.copyOfRange(parts, 1, parts.length);
                if (operation.equalsIgnoreCase("help") || operation.equalsIgnoreCase("?")) {
                    printHelp();
                } else if (operation.equalsIgnoreCase("q") || operation.equalsIgnoreCase("quit")) {
                    done = true;
                } else if (operation.equals("set")) {
                    setValue(client, command, args);
                } else if (operation.equals("remove")) {
                    remove(client, command, args);
                } else if (operation.equals("list")) {
                    list(cache);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void list(TreeCache cache) {
        if(cache.getCurrentChildren(PATH).size() == 0) {
            System.err.println("* empty *");
        } else {
            for (Map.Entry<String, ChildData> entry : cache.getCurrentChildren(PATH).entrySet()) {
                System.err.println(entry.getKey() + " = " + new String(entry.getValue().getData()));
            }
        }
    }

    private static void remove(CuratorFramework client, String command, String[] args) {
        if(args.length != 1) {
            System.err.println("syntax error (expected remove <value>):" + command);
            return;
        }
        String name = args[0];
        if(name.contains("/")) {
            System.err.println("Invalid node name:" + name);
            return;
        }
        String path = ZKPaths.makePath(PATH, name);
        try {
            client.delete().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setValue(CuratorFramework client, String command, String[] args) {
        if(args.length != 2) {
            System.err.println("syntax error (expected set <value>):" + command);
            return;
        }
        String name = args[0];
        if(name.contains("/")) {
            System.err.println("Invalid node name:" + name);
            return;
        }
        String path = ZKPaths.makePath(PATH, name);
        byte[] bytes = args[1].getBytes();
        try {
            client.setData().forPath(path, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addListener(final TreeCache cache) {
        TreeCacheListener listener = (client, event) -> {
            switch (event.getType()) {
                case NODE_ADDED:
                    System.err.println("TreeNode added:" + ZKPaths.getNodeFromPath(event.getData().getPath())
                            + ", value: " + new String(event.getData().getData()));
                    break;
                case NODE_UPDATED:
                    System.err.println("TreeNode changed:"+ ZKPaths.getNodeFromPath(event.getData().getPath())
                            + ", value: " + new String(event.getData().getData()));
                    break;
                case NODE_REMOVED:
                    System.err.println("TreeNode removed:" + ZKPaths.getNodeFromPath(event.getData().getPath()));
                    break;
                default:
                    System.err.println("Other event:" + event.getType().name());
            }
        };
        cache.getListenable().addListener(listener);
    }

    private static void printHelp() {
        System.out.println("\nAn example of using PathChildrenCache. This example is driven by entering commands at the prompt:\n");
        System.out.println("set <path> <value>: Adds or updates a node with the given name");
        System.out.println("remove <path>: Deletes the node with the given name");
        System.out.println("list: List the nodes/values in the cache");
        System.out.println("quit: Quit the example");
        System.out.println();
    }
}
