package com.tree.www.zk.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2017/8/21.
 */
public class InterProcessMutexExample {
    private static final int QTY = 1;
    private static final int REPETITIONS = QTY * 1;
    private static final String PATH = "/examples/locks";

    public static void main(String[] args) throws Exception {
        final FakeLimitedResource resource = new FakeLimitedResource();
        ExecutorService executorService = Executors.newFixedThreadPool(QTY);
        final TestingServer server = new TestingServer();
        try {
            for (int i = 0; i < QTY; i++) {
                final int index = i;
                Callable<Void> task = () -> {
                    CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                            new ExponentialBackoffRetry(1000, 3));
                    try {
                        client.start();
                        final ExampleClientThatLocks example = new ExampleClientThatLocks(client, PATH, resource, "Client " + index);
                        for (int j = 0; j < REPETITIONS; j++) {
                            example.doWork(200, TimeUnit.MILLISECONDS);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        CloseableUtils.closeQuietly(client);
                    }
                    return null;
                };
                executorService.submit(task);
            }
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } finally {
            CloseableUtils.closeQuietly(server);
        }
    }
}
