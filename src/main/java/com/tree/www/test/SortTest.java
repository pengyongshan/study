package com.tree.www.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortTest {
	public static void main(String[] args) {

		int[] sample = new int[] { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,1,0,-2,0,0,0,0};
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer integer : sample) {
			list.add(integer);
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() < o2.intValue() ? -1 : o1.intValue() == o2.intValue() ? 0 : 1;
			}
		});
		System.out.println(list);
	}

}
