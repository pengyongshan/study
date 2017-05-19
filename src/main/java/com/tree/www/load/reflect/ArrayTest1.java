package com.tree.www.load.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

// 操作数组
public class ArrayTest1 {

	public static void main(String[] args) {
		Object arr = Array.newInstance(String.class, 10); // 创建String[10]
		Array.set(arr, 5, "高数");
		Array.set(arr, 6, "java");
		Object obj1 = Array.get(arr, 5);
		Object obj2 = Array.get(arr, 6);

		String[] str = (String[]) arr;
		System.out.println(Arrays.toString(str));
		System.out.println(obj1 + " " + obj2);
	}
}
