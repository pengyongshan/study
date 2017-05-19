package com.tree.www.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {

	// 用于检测所有Channel状态的Selector
	private Selector selector = null;
	static int port = 30000;
	private Charset charset = Charset.forName("UTF-8");

	public void init() throws IOException {
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", port);
		// serversocketchannel绑定指定Ip
		server.bind(isa);
		// 设置成非阻塞方式
		server.configureBlocking(false);
		// 注册到selector
		server.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			// 依次处理selector上的每个已选择的selectionKey
			for (SelectionKey sk : selector.selectedKeys()) {
				// 从selector上的每个已选择Key集中删除正在处理的SelectionKey
				selector.selectedKeys().remove(sk);
				if (sk.isAcceptable()) { // sk对应的Channel包含客户端的连接请求
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					// 将sk对应的Channel设置成准备接受其他请求
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}

				if (sk.isReadable()) { // sk对应的Channel有数据需要读取
					SocketChannel sc = (SocketChannel) sk.channel();
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while (sc.read(buff) > 0) {
							buff.flip();
							content += charset.decode(buff);
						}

						System.out.println("读取的数据:" + content);
						// 准备下一次读取
						sk.interestOps(SelectionKey.OP_READ);
					} catch (IOException ex) {
						sk.cancel(); // 删除指定的SelectionKey
						if (sk.channel() != null) {
							sk.channel().close();
						}
					}

					if (content.length() > 0) {
						// 遍历该 selector注册的所有SelectionKey
						for (SelectionKey key : selector.keys()) {
							Channel targetChannel = key.channel();

							if (targetChannel instanceof SocketChannel) {
								SocketChannel dest = (SocketChannel) targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new NServer().init();
	}
}
