package com.tree.www.thread;

public class TestSync implements Runnable {

	Timer timer = new Timer();

	public static void main(String[] args) {
		TestSync test = new TestSync();
		Thread t1 = new Thread(test, "t1");
		Thread t2 = new Thread(test, "t2");
		Thread t3 = new Thread(test, "t3");
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}

}

class Timer {

	private static int num = 0;

	public void add(String name) {
		synchronized (this) {
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + ":第" + num + "个");
		}
	}
}
