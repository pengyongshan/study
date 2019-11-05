package com.tree.www.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by pysh on 2019-11-05.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8080));
        Attachment attachment = new Attachment();
        attachment.setServer(server);

        server.accept(attachment, new CompletionHandler<AsynchronousSocketChannel, Attachment>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Attachment attachment) {
                try {
                    SocketAddress clientAddr = client.getRemoteAddress();
                    System.out.println("收到新的连接:" + clientAddr);

                    // 收到新的连接后， server应该重新调用accept方法等待新的连接进来
                    attachment.getServer().accept(attachment, this);

                    Attachment newAttr = new Attachment();
                    newAttr.setServer(server);
                    newAttr.setClient(client);
                    newAttr.setReadMode(true);
                    newAttr.setBuffer(ByteBuffer.allocate(1024));

                    client.read(newAttr.getBuffer(), newAttr, new ChannelHandler());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, Attachment attachment) {
                System.out.println("accept failed!");
            }
        });
        // 防止main线程退出
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
}
