package com.tree.www.collection;

import java.util.ArrayDeque;
import java.util.Deque;

// ArrayDeque当队列用,先进先出
public class ArrayDequeQueue {
	public static void main(String[] args) {
		Deque queue = new ArrayDeque();
		queue.offer("java"); // 等价于 add addLast
		queue.offer("eclipse");
		queue.offer("hello");
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
