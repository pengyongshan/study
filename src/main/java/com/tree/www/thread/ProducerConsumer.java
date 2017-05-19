package com.tree.www.thread;

/**
 * 生产者--消费者问题
 * 
 * 1.共享数据的不一致/临界资源的保护 2.Java 对象锁的概念 3.synchronized关键字/wait()及notify()方法的使用
 * 
 * @author pys
 *
 * @date 2016年5月19日 上午11:40:57
 */
public class ProducerConsumer {
	
	public static void main(String[] args) {
		SyncStack stack = new SyncStack();
		
		Thread p1 = new Thread(new Producer(stack));
		Thread c1 = new Thread(new Consumer(stack));
		
		p1.start();
		c1.start();
		System.out.println(Long.MAX_VALUE);
	}

}

class SyncStack { // 支持多线程同步操作的堆栈的实现

	private int index = 0;

	private char[] data = new char[6];

	public synchronized void push(char c) {
		if (index == data.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		data[index] = c;
		index++;
	}

	public synchronized char pop() {
		if (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return data[index];
	}

}

class Producer implements Runnable {

	SyncStack stack;

	public Producer(SyncStack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			char c = (char) (Math.random() * 26 + 'A');
			stack.push(c);
			System.out.println("生产:" + c);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {

	SyncStack stack;

	public Consumer(SyncStack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			char c = stack.pop();
			System.out.println("消费:" + c);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
