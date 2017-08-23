package com.tree.www.zk.counter;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.test.TestingServer;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计数器 long型
 *
 * Created by pysh on 2017/8/23.
 */
public class DistributedAtomicLongExample {
    private static final int QTY = 5;
    private static final String PATH = "/examples/counter";

    public static void main(String[] args) throws Exception {
        try(TestingServer server = new TestingServer()) {
            CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            //List<DistributedAtomicLong> examples = Lists.newArrayList();
            ExecutorService service = Executors.newFixedThreadPool(QTY);
            Random random = new Random();
            for(int i = 0; i < QTY; i ++) {
                final DistributedAtomicLong count = new DistributedAtomicLong(client, PATH,
                        new RetryNTimes(3, 10));
               // examples.add(count);

                Callable<Void> task = () -> {
                    try {
                        Thread.sleep(random.nextInt(1000));
                        AtomicValue<Long> value = count.increment();
                        //AtomicValue<Long> value1 = count.decrement();
                        //AtomicValue<Long> value2 = count.add(random.nextLong());
                        //AtomicValue<Long> value3 = count.trySet(100L);
                        //AtomicValue<Long> value4 = count.subtract(random.nextLong());
                        if (value.succeeded()) {
                            System.err.println("Increment: from " + value.preValue() + " to " + value.postValue());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                };
                service.submit(task);
            }

            service.shutdown();
            service.awaitTermination(10, TimeUnit.MINUTES);
        }
    }
}
