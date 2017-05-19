package com.tree.www.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;



public class NClient {
	private Selector selector = null;
	static final int port = 30000;
	private Charset charset = Charset.forName("UTF-8");
	private SocketChannel sc = null;

	public static void main(String[] args) throws IOException {
		new NClient().init();
	}

	public void init() throws IOException {
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", port);
		sc = SocketChannel.open(isa);
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		new ClientThread().start(); // 启动读取服务端数据的线程
		// 创建键盘输入流
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			// 将内容输出到SocketChnnel
			sc.write(charset.encode(line));
		}
	}

	private class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				while (selector.select() > 0) {
					for (SelectionKey sk : selector.selectedKeys()) {
						selector.selectedKeys().remove(sk);
						if (sk.isReadable()) {
							SocketChannel sc = (SocketChannel) sk.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							String content = "";
							while (sc.read(buff) > 0) {
								sc.read(buff);
								buff.flip();
								content += charset.decode(buff);
							}
							System.out.println("聊天信息:" + content);
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
