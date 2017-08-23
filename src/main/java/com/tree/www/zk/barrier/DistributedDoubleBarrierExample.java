package com.tree.www.zk.barrier;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 双栅栏
 * <p>
 * Created by pysh on 2017/8/23.
 */
public class DistributedDoubleBarrierExample {
    private static final int QTY = 5;
    private static final String PATH = "/examples/barrier";

    public static void main(String[] args) throws Exception {
        try (TestingServer server = new TestingServer()) {
            CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            ExecutorService es = Executors.newFixedThreadPool(QTY);
            for (int i = 0; i < QTY; i++) {
                final DistributedDoubleBarrier barrier = new DistributedDoubleBarrier(client, PATH, QTY);
                final int index = i;
                Callable<Void> task = () -> {
                    Thread.sleep((long) (3 * Math.random()));
                    System.err.println("Client #" + index + " enters");
                    barrier.enter();
                    System.err.println("Client #" + index + " begins");
                    Thread.sleep((long) (3000 * Math.random()));
                    barrier.leave();
                    System.err.println("Client #" + index + " left");
                    return null;
                };
                es.submit(task);
            }

            es.shutdown();
            es.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}

