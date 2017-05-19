package com.tree.www.collection;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {

	// 根据严格相等(==) 判断key是否相等
	public static void main(String[] args) {
		Map map = new IdentityHashMap();
		map.put("java", "ccc");
		map.put("java", "aaa");
		map.put(new String("java"), "ddd");
		map.put(new String("java"), "bbb");
		System.out.println(map);
	}
}
