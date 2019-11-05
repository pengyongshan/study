package com.tree.www.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * Created by pysh on 2019-11-05.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<?> future = client.connect(new InetSocketAddress(8080));
        // 阻塞等待连接成功
        future.get();

        Attachment attachment = new Attachment();
        attachment.setClient(client);
        attachment.setReadMode(false);
        attachment.setBuffer(ByteBuffer.allocate(1024));
        byte[] data = "I'm obot!".getBytes();
        attachment.getBuffer().put(data);
        attachment.getBuffer().flip();

        client.write(attachment.getBuffer(), attachment, new ClientChannelHandler());

        Thread.sleep(2000); // 等待处理数据
    }
}
