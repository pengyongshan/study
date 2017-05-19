package com.tree.www.io.test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流 —— 线程之间的通信
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test11 {
	public static void main(String[] args) throws IOException {
		Send send = new Send();
		Recive recive = new Recive();

		// send.getOut().connect(recive.getIn());
		recive.getIn().connect(send.getOut());
		new Thread(recive).start();
		new Thread(send).start();
	}
}

class Send implements Runnable {

	private PipedOutputStream out = null;

	public Send() {
		out = new PipedOutputStream();
	}

	public PipedOutputStream getOut() {
		return this.out;
	}

	@Override
	public void run() {
		String msg = "hello, pys";
		try {
			out.write(msg.getBytes());
			out.close();
			System.out.println("发送：" + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Recive implements Runnable {

	private PipedInputStream in = null;

	public Recive() {
		in = new PipedInputStream();
	}

	public PipedInputStream getIn() {
		return this.in;
	}

	@Override
	public void run() {
		byte[] b = new byte[1024];
		try {
			this.in.read(b);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("接收：" + new String(b));
	}

}
