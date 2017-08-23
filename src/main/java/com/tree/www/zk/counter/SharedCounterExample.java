package com.tree.www.zk.counter;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.shared.SharedCount;
import org.apache.curator.framework.recipes.shared.SharedCountListener;
import org.apache.curator.framework.recipes.shared.SharedCountReader;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计数器int型
 *
 * Created by pysh on 2017/8/23.
 */
public class SharedCounterExample implements SharedCountListener{

    private static final int QTY = 5;
    private static final String PATH = "/examples/counter";

    public static void main(String[] args) throws Exception {
        final Random random = new Random();
        SharedCounterExample example = new SharedCounterExample();

        try(TestingServer server = new TestingServer()) {
            CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            SharedCount baseCount = new SharedCount(client, PATH, 0);
            baseCount.addListener(example);
            baseCount.start();

            List<SharedCount> counts = Lists.newArrayList();
            ExecutorService service = Executors.newFixedThreadPool(QTY);
            for(int i = 0; i < QTY; i++) {
                final SharedCount count = new SharedCount(client, PATH, 0);
                counts.add(count);
                Callable<Void> task = () -> {
                    count.start();
                    Thread.sleep(random.nextInt(10000));
                    System.err.println("Increment:" + count.trySetCount(count.getVersionedValue(),
                            count.getCount() + random.nextInt(10)));
                    return null;
                };
                service.submit(task);
            }

            Thread.sleep(10000);
            service.shutdown();
            service.awaitTermination(10, TimeUnit.MINUTES);

            for (SharedCount count : counts) {
                count.close();
            }

            baseCount.close();
        }
    }

    @Override
    public void countHasChanged(SharedCountReader sharedCount, int newCount) throws Exception {
        System.err.println("Counter's value is changed to " + newCount);
    }

    @Override
    public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
        System.err.println("State change: " + connectionState);
    }
}
