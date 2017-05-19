package com.tree.www.collection;

import java.util.ArrayDeque;
import java.util.Deque;

//ArrayDeque当成栈，先进后出
public class  ArrayDequeStack {

	public static void main(String[] args) {
		Deque stack = new ArrayDeque();
		stack.push("java"); // 等价于offerFirst, addFirst
		stack.addFirst("eclipse");
		stack.push("hello");
		System.out.println(stack);
		System.out.println(stack.peek()); // 访问第一个元素但不删除
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
