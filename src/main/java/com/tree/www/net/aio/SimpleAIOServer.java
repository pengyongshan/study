package com.tree.www.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class SimpleAIOServer {

	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {
		AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress(PORT));
		while(true) {
			Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
			AsynchronousSocketChannel socketChannel = future.get();
			socketChannel.write(ByteBuffer.wrap("欢迎学习AIO".getBytes("UTF-8"))).get();
		}
	}
}
