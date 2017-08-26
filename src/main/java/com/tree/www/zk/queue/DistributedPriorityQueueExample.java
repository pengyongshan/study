package com.tree.www.zk.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

/**
 * 优先级队列对队列中的元素按照优先级进行排序。
 * Priority越小， 元素月靠前， 越先被消费掉。
 *
 * 当优先级队列得到元素增删消息时，它会暂停处理当前的元素队列，然后刷新队列。
 *
 * Created by pysh on 2017/8/26.
 */
public class DistributedPriorityQueueExample {
    private static final String PATH = "/example/queue";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = null;
        DistributedPriorityQueue<String> queue = null;

        try {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.getCuratorListenable().addListener((client1, event) ->
                    System.out.println("CuratorEvent:" + event.getType().name()));

            client.start();
            QueueConsumer<String> consumer = createQueueConsumer();
            QueueBuilder<String> builder = QueueBuilder.builder(client, consumer, createQueueSerializer(), PATH);
            queue = builder.buildPriorityQueue(0);
            queue.start();
            for (int i = 0; i < 15; i++) {
                int priority = 15 - i; //(int) (Math.random() * 100);
                try {
                    System.out.println("test-" + i + " priority:" + priority);
                    queue.put(" test-" + i, priority);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Thread.sleep(10000);
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
                System.out.println("consumer one message:" + message);
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                System.out.println("connection new state:" + newState.name());
            }
        };
    }
}
