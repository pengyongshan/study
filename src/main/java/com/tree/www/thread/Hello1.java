package com.tree.www.thread;

public class Hello1 extends Thread {

	private int count = 15;

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			if (count > 0) {
				System.out.println(this.getName() + " count=" + count--);
			}
		}
	}

	public static void main(String[] args) {
		Hello1 h1 = new Hello1();
		Hello1 h2 = new Hello1();
		Thread demo1 = new Thread(h1);
		demo1.setPriority(MAX_PRIORITY);
		Thread demo2 = new Thread(h2);
		demo2.start();
		demo1.start();

	}

}
