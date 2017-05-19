package com.tree.www.collection;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		books.add("aaa");
		books.offer("bbb"); // 队列
		books.push("ccc"); // 栈
		books.offerFirst("ddd"); // 栈
		for (Object object : books) {
			System.out.print(object + " ");
		}
		System.out.println();
		System.out.println(books.peek());
		System.out.println(books.peekLast());

		System.out.println(books.pop());
		System.out.println(books.poll());
		System.out.println(books.pollLast());

		System.out.println(books);
	}
}
