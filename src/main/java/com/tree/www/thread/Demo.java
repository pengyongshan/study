package com.tree.www.thread;

// wait(),notify() 只能用于 同步
public class Demo implements Runnable {

	private String name;

	private Object prev;

	private Object self;

	private Demo(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					self.notify();
					System.out.print(name);
					count--;
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		Demo demo1 = new Demo("A", c, a);
		Demo demo2 = new Demo("B", a, b);
		Demo demo3 = new Demo("C", b, c);

		new Thread(demo1).start();
		Thread.sleep(10);
		new Thread(demo2).start();
		Thread.sleep(10);
		new Thread(demo3).start();

	}
}
