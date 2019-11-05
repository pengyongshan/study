package com.tree.www.io.nio.socket;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * Created by pysh on 2019-11-04.
 */
public class SocketChannelHandler implements Runnable {

    private SocketChannel socketChannel;

    public SocketChannelHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int num;
            while ((num = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                byte[] bytes = new byte[num];
                buffer.get(bytes);
                String re = new String(bytes, StandardCharsets.UTF_8);
                System.out.println("收到请求:" + re);

                // 回应
                ByteBuffer writeBuffer = ByteBuffer.wrap(("已收到你的请求，内容：" + re).getBytes());
                socketChannel.write(writeBuffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
