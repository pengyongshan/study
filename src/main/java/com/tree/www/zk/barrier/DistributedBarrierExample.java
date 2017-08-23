package com.tree.www.zk.barrier;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

import java.util.concurrent.*;

/**
 * 栅栏
 *
 * Created by pysh on 2017/8/23.
 */
public class DistributedBarrierExample {
    private static final int QTY = 5;
    private static final String PATH = "/examples/barrier";

    public static void main(String[] args) throws Exception {
        try(TestingServer server = new TestingServer()) {
            CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            ExecutorService es = Executors.newFixedThreadPool(QTY);
            DistributedBarrier controlBarrier = new DistributedBarrier(client, PATH);
            controlBarrier.setBarrier();

            for(int i = 0; i < QTY; i++) {
                final int index = i;
                Callable<Void> task = () -> {
                    Thread.sleep((long) (3 * Math.random()));
                    System.err.println("Client #" + index + " waits on Barrier");
                    controlBarrier.waitOnBarrier();
                    System.err.println("Client #" + index + " begins");
                    return null;
                };
                es.submit(task);
            }
            Thread.sleep(1000);
            System.err.println("all Barrier instances should wait the condition");

            controlBarrier.removeBarrier();

            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
