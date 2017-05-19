package com.tree.www.thread;

/**
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 
 * @author pys
 *
 * @date 2016年5月4日 下午2:52:00
 */
public class Hello2 implements Runnable {

	private int count = 15;

	@Override
	public synchronized void run() {
		for (int i = 0; i < 7; i++) {
			if (count > 0) {
			   /* try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
				System.out.println(Thread.currentThread().getName() + " count=" + count--);
			}
		}
	}

	public static void main(String[] args) {
		Hello2 h1 = new Hello2();
		Thread demo = new Thread(h1);
		Thread demo2 = new Thread(h1);
		Thread demo3 = new Thread(h1);
		demo.start();
		demo2.start();
		demo3.start();
	}

}
