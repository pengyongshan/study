package com.tree.www.load.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
		Object arr = Array.newInstance(String.class, 3, 4, 10); // 3维
		Object arrObj = Array.get(arr, 2); // 3维下的二维数组，下标为2
		// arrObj的下标为2的一维数组设为{ "java", "高数" }
		Array.set(arrObj, 2, new String[] { "java", "高数" });
		Object anArr = Array.get(arrObj, 3); // // arrObj的下标为3的一维数组
		Array.set(anArr, 7, "语文"); // 一维数组的下标为7的元素设为 语文
		String[][][] cast = (String[][][]) arr;
		for (String[][] strings : cast) {
			for (String[] strings2 : strings) {
				System.out.println(Arrays.toString(strings2));
			}
		}
	}
}
