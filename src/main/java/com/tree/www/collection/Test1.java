package com.tree.www.collection;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] strs = { "a", "b", "a", "b", "c", "a", "b", "c", "b" };
		for (String string : strs) {
			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}
		}
		System.out.println(map);
	}
}
