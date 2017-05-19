package com.tree.www.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
	// 当构造函数的参数与调用方法顺序一样 会产生相同的数字序列 伪随机
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt(10));
		System.out.println(rand.nextDouble());
		Random rand2 = new Random();
		System.out.println(rand2.nextInt(10));
		System.out.println(rand2.nextDouble());

		ThreadLocalRandom thlr = ThreadLocalRandom.current();
		System.out.println(thlr.nextInt(10, 20));
	}
}
