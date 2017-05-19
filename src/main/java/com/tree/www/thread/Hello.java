package com.tree.www.thread;

public class Hello extends Thread {

	private String name;

	public Hello() {
		// TODO Auto-generated constructor stub
	}

	public Hello(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  " + i);
		}
	}

	public static void main(String[] args) {
		Hello h1 = new Hello("A");
		Hello h2 = new Hello("B");
		h1.run(); // 只是调用普通方法
		h2.run();

		System.out.println();
		// 用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执
		// 行下面的代码。通过调用Thread类的start()方法来启动一个线程，
		// s这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，就开始执行run()方法，这里方法
		// run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。
		h1.start();
		h2.start();
	}
}
