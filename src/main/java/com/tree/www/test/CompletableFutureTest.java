package com.tree.www.test;

import com.google.common.collect.Lists;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2021/2/5.
 */
public class CompletableFutureTest {

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Executor executor = Executors.newFixedThreadPool(10);
		long s = System.currentTimeMillis();
		List<CompletableFuture<Integer>> taskList = new ArrayList<>(list.size());
		list.forEach(id -> taskList.add(CompletableFuture.supplyAsync(() -> {
			try {
				return new CompletableFutureTest().convertId(id);
			} catch (Exception e) {
				return 0;
			}
		}, executor)));
		int success = taskList.stream().map(CompletableFuture::join)
						.mapToInt(Integer::valueOf).sum();
		System.out.println(System.currentTimeMillis() - s);
		System.out.println(success);
	}

	private Integer convertId(Integer id) throws InterruptedException {
		TimeUnit.SECONDS.sleep(id * 2);
		return id * 2;
	}
}
