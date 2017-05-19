package com.tree.www.thread;

// join line-26
public class Hello3 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 13; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		Hello3 h = new Hello3();
		Thread demo = new Thread(h, "线程");
		demo.start();
		for (int i = 0; i < 50; i++) {
			if (i > 5) {
				try {
					demo.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("main 线程执行-->" + i);
		}
	}
}
