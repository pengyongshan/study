package com.tree.www.thread;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2021/1/28.
 */
public class ExecutorTimeout {

	static Random random = new Random();
	static long timeout = 5000;
	static ExecutorService es = Executors.newFixedThreadPool(4);

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
		System.out.println("result:" + new ExecutorTimeout().A(list));
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
	}

	public Map<String, Integer> A(List<String> list) {
		long current = System.currentTimeMillis();
		Map<String, Integer> res = new HashMap<>();
		for (String str : list) {
			es.submit(() -> res.put(str, B(str)));
		}
		boolean b = false;
		try {
			// timeout-前面的耗时-后续组装参数耗时(暂定200)
			b = es.awaitTermination(timeout + current - System.currentTimeMillis()-200, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!b) {
			for (String str : list) {
				if (!res.containsKey(str)) {
					res.put(str, -1); // 代表超时
				}
			}
		}
		es.shutdown();
		return res;
	}

	public Integer B(String a) {
		int rest = random.nextInt(10);
		try {
			System.out.println(rest);
			TimeUnit.SECONDS.sleep(rest);
		} catch (InterruptedException e) {
			return 0;
		}
		return (int) a.toCharArray()[0];
	}

}
