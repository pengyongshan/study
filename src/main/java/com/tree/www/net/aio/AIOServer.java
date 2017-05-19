package com.tree.www.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class AIOServer {

	static final int PORT = 30000;
	static final String UTF_8 = "utf-8";
	static List<AsynchronousSocketChannel> channels = new ArrayList<>();

	public void startListen() throws Exception {
		// 设置线程数为CPU核数
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup
				.withFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
				.bind(new InetSocketAddress(PORT));
		// 使用CompletionHandle接收来自客户端的连接请求
		serverChannel.accept(this, new AcceptHandle(serverChannel));
	}

	public static void main(String[] args) throws Exception {
		AIOServer server = new AIOServer();
		server.startListen();
	}
}

class AcceptHandle implements CompletionHandler<AsynchronousSocketChannel, Object> {

	private AsynchronousServerSocketChannel serverChannel;

	ByteBuffer buff = ByteBuffer.allocate(1024);

	public AcceptHandle(AsynchronousServerSocketChannel serverChannel) {
		this.serverChannel = serverChannel;
	}

	@Override
	public synchronized void completed(final AsynchronousSocketChannel sc, Object attachment) {
		AIOServer.channels.add(sc); // 记录新连进来的Channel
		serverChannel.accept(null, this); // 准备接受客户端的下一次连接
		sc.read(buff, null, new CompletionHandler<Integer, Object>() {

			@Override
			public void completed(Integer result, Object attachment) {
				buff.flip();
				String content = StandardCharsets.UTF_8.decode(buff).toString();
				// 遍历每个Channel,写入收到的信息
				for (AsynchronousSocketChannel asc : AIOServer.channels) {
					try {
						asc.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				buff.clear();
				sc.read(buff, null, this);
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("读取数据失败：" + exc);
				AIOServer.channels.remove(sc);
			}
		});

	}

	@Override
	public void failed(Throwable exc, Object attachment) {
		System.out.println("连接失败：" + exc);
	}
}
