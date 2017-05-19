package com.tree.www.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

public class SimpleAIOClient {

	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Charset charset = Charset.forName("utf-8");
		AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
		buffer.clear();
		socketChannel.read(buffer).get();
		buffer.flip();
		String content = charset.decode(buffer).toString();
		System.out.println("服务器信息:" + content);
		socketChannel.close();
	}
}
