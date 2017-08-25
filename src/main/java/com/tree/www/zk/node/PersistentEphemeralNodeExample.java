package com.tree.www.zk.node;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.nodes.PersistentEphemeralNode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.KillSession;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.util.concurrent.TimeUnit;

/**
 * 临时节点
 * <p>
 * Created by pysh on 2017/8/25.
 */
public class PersistentEphemeralNodeExample {
    private static final String PATH = "/example/ephemeralNode";
    private static final String PATH2 = "/example/node";

    public static void main(String[] args) throws Exception {
        TestingServer server =  new TestingServer();
        CuratorFramework client = null;
        PersistentEphemeralNode node = null;
        try {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.getConnectionStateListenable().addListener((client1, newState)
                    -> System.err.println("client state:" + newState.name()));
            client.start();

            node = new PersistentEphemeralNode(client, PersistentEphemeralNode.Mode.EPHEMERAL, PATH, "test".getBytes());
            node.start();
            node.waitForInitialCreate(10, TimeUnit.SECONDS);
            String actualPath = node.getActualPath();
            System.err.println("node " + actualPath + " value: " + new String(client.getData().forPath(PATH)));

            client.create().forPath(PATH2, "persistent node".getBytes());
            System.err.println("node " + PATH2 + " value: " + new String(client.getData().forPath(PATH2)));
            KillSession.kill(client.getZookeeperClient().getZooKeeper(), server.getConnectString());
            System.err.println("node " + actualPath + " doesn't exist: " + (client.checkExists().forPath(actualPath) == null));
            System.err.println("node " + PATH2 + " value: " + new String(client.getData().forPath(PATH2)));
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(node);
            CloseableUtils.closeQuietly(client);
            CloseableUtils.closeQuietly(server);
        }
    }
}
