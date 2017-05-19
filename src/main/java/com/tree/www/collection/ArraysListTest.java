package com.tree.www.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysListTest {
	public static void main(String[] args) {
		// list是Arrays的内部类ArrayList的实例.长度固定
		List list = Arrays.asList("a", "b");
		for (Object object : list) {
			System.out.println(object);
		}
		list.set(0, "c"); // 可修改
		// list.add("c"); // 不可增加、删除
		// list.remove("a");
	}
}
