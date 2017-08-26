package com.tree.www.zk.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.DistributedDelayQueue;
import org.apache.curator.framework.recipes.queue.QueueBuilder;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.recipes.queue.QueueSerializer;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.util.Date;

/**
 * 延迟队列，一段时间过后才被消费
 * <p>
 * Created by pysh on 2017/8/26.
 */
public class DistributedDelayQueueExample {
    private static final String PATH = "/example/queue";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = null;
        DistributedDelayQueue<String> queue = null;

        try {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.getCuratorListenable().addListener((client1, event) ->
                    System.out.println("CuratorEvent:" + event.getType().name()));

            client.start();
            QueueConsumer<String> consumer = createQueueConsumer();
            QueueBuilder<String> builder = QueueBuilder.builder(client, consumer, createQueueSerializer(), PATH);
            queue = builder.buildDelayQueue();
            queue.start();
            for (int i = 1; i < 15; i++) {
                System.out.println("test-" + i);
                queue.put(" test-" + i, System.currentTimeMillis() + 10000);
            }
            System.out.println(new Date().getTime() + ": already put all items");
            Thread.sleep(20000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(queue);
            CloseableUtils.closeQuietly(client);
            CloseableUtils.closeQuietly(server);
        }

    }

    private static QueueSerializer<String> createQueueSerializer() {
        return new QueueSerializer<String>() {
            @Override
            public byte[] serialize(String item) {
                return item.getBytes();
            }

            @Override
            public String deserialize(byte[] bytes) {
                return new String(bytes);
            }
        };
    }

    private static QueueConsumer<String> createQueueConsumer() {
        return new QueueConsumer<String>() {
            @Override
            public void consumeMessage(String message) throws Exception {
                System.out.println("currentTime:" + System.currentTimeMillis() +", consumer one message:" + message);
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                System.out.println("connection new state:" + newState.name());
            }
        };
    }
}
