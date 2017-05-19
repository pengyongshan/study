package com.tree.www.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	// 与LinkedHashSet类似 双向链表 ，顺序与添加顺序一致
	public static void main(String[] args) {
		Map map = new LinkedHashMap();
		map.put("aa", 1);
		map.put("bb", 2);
		map.put("cc", 3);
		map.put(null, 4);
		map.put("hh", 6);
		System.out.println(map);

	}
}
