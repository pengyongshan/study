package com.tree.www.zk.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.DistributedIdQueue;
import org.apache.curator.framework.recipes.queue.QueueBuilder;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.recipes.queue.QueueSerializer;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

/**
 * 为队列中的每一个元素设置一个ID
 *
 * 有些元素还没有被消费者消费时就移除了，
 * 这样消费者不会收到删除的消息
 *
 * Created by pysh on 2017/8/26.
 */
public class DistributedIdQueueExample {
    private static final String PATH = "/example/queue";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = null;
        DistributedIdQueue<String> queue = null;

        try {
            client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.getCuratorListenable().addListener((client1, event) ->
                    System.out.println("CuratorEvent:" + event.getType().name()));

            client.start();
            QueueConsumer<String> consumer = createQueueConsumer();
            QueueBuilder<String> builder = QueueBuilder.builder(client, consumer, createQueueSerializer(), PATH);
            queue = builder.buildIdQueue();
            queue.start();
            for (int i = 0; i < 15; i++) {
                try {
                    queue.put(" test-" + i, "ID" + i);
                    Thread.sleep((long) (10 * Math.random()));
                    queue.remove("ID" + i);
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
