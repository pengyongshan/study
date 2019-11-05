package com.tree.www.io.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by pysh on 2019-11-04.
 */
public class SelectorServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        // 将serverSocketChannel注册到selector监听OP_ACCEPT
        serverSocketChannel.configureBlocking(false); // 非阻塞
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannel = selector.select();
            if(readyChannel == 0) {
                continue;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if(key.isAcceptable()) { // 有已经接受的新的请求
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if(key.isReadable()) {
                    // 上面if注册的读取事件的socketChannel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int num = socketChannel.read(readBuffer);
                    if(num > 0) {
                        System.out.println("收到数据：" + new String(readBuffer.array()).trim());
                        ByteBuffer writeBuffer = ByteBuffer.wrap(("已收到你的请求，over").getBytes());
                        socketChannel.write(writeBuffer);
                    } else if (num == -1) {
                        // 代表连接已关闭
                        socketChannel.close();
                    }
                }
            }
        }
    }
}
