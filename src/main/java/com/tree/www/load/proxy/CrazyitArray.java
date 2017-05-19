package com.tree.www.load.proxy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CrazyitArray {

	public static <T> T[] newInstance(Class<T> componenType, int length) {
		return (T[]) Array.newInstance(componenType, length);
	}

	public static void main(String[] args) {
		String[] arr = CrazyitArray.newInstance(String.class, 10);
		int[][] intArr = CrazyitArray.newInstance(int[].class, 5);
		arr[5] = "xxxx";
		intArr[1] = new int[] { 1, 7 };
		System.out.println(Arrays.toString(arr));
		for (int[] is : intArr) {
			System.out.println(Arrays.toString(is));
		}
	}
}
