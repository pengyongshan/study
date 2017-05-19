package com.tree.www.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Sum {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] arr = new int[100];
		Random rand = new Random();
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(20);
			total += arr[i];
		}
		System.out.println(total);
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		pool.shutdown();
	}
}

class CalTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;

	public CalTask(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;
		} else {
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}

}
