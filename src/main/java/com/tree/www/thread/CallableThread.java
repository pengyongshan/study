package com.tree.www.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// 有返回值的子线程
public class CallableThread {

	public static void main(String[] args) {
		CallableThread thread = new CallableThread();
		// 使用FutureTask包装Callable对象
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

			int i = 0;
			@Override
			public Integer call() throws Exception {
				for (; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "--i = " + i);
				}
				return i;
			}
		});

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "--i = " + i);
			if (i == 20) {
				new Thread(task).start();
			}
		}
		try {
			System.out.println("子线程的返回值：" + task.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
