package com.tree.www.thread;

import java.util.concurrent.*;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Runnable target = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "的i值为：" + i);
			}
		};
		pool.submit(target);
		pool.submit(target);
		pool.submit(target);
		pool.submit(target);
		pool.shutdown();

		ExecutorService pool2 = new ThreadPoolExecutor(2, 4,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(20));
		for (int i = 0; i < 100; i++) {
			pool2.submit(target);
		}
	}
}
