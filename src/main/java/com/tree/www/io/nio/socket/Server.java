package com.tree.www.io.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by pysh on 2019-11-04.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            SocketChannelHandler handler = new SocketChannelHandler(socketChannel);
            new Thread(handler).start();
        }

    }
}
