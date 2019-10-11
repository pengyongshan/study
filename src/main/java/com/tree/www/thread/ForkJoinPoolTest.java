package com.tree.www.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

// 分解任务
public class ForkJoinPoolTest {

	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new PrintTask(0, 900));
		try {
			pool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
	}
}

class PrintTask extends RecursiveAction {

	private static final long serialVersionUID = 8710089300517620669L;
	private static final int THRESHOLD = 50;

	private int start;

	private int end;

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + "的i值:" + i);
			}
		} else {
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			left.fork();
			right.fork();
		}
	}

}
