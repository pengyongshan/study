package com.tree.www.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	// 按元素大小排序 规则与TreeSet一致
	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		pq.offer(4);
		pq.offer(-8);
		pq.offer(3);
		pq.offer(10);
		System.out.println(pq); // 不是按顺序是受到toString返回值的影响
		for (int i = 0; i < 4; i++) {
			System.out.print(pq.poll() + " ");
		}
	}
}
