package com.tree.www.zk.framework;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

/**
 * Created by pysh on 2017/8/26.
 */
public class CreateClientExample {
    private static final String PATH = "/example/basic";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = null;

        try{
            client = createSimple(server.getConnectString());
            client.start();
            client.create().creatingParentsIfNeeded().forPath(PATH, "test".getBytes());
            CloseableUtils.closeQuietly(client);

            client = createWithOptions(server.getConnectString(), new ExponentialBackoffRetry(1000, 3), 1000, 1000);
            client.start();
            System.out.println(new String(client.getData().forPath(PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
            CloseableUtils.closeQuietly(server);
        }
    }

    private static CuratorFramework createWithOptions(String connectString, ExponentialBackoffRetry exponentialBackoffRetry, int connectTiemoutMs, int sessionTimeoutMs) {
        return CuratorFrameworkFactory.builder().connectString(connectString)
                .retryPolicy(exponentialBackoffRetry)
                .connectionTimeoutMs(connectTiemoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .build();
    }

    private static CuratorFramework createSimple(String connectString) {
        // The first retry will wait 1 second
        // the second will wait up to 2 seconds
        // the third will wait up to 4 seconds.
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        return CuratorFrameworkFactory.newClient(connectString, retryPolicy);
    }
}
