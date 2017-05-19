package com.tree.www.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
	/** 输出set集合时元素的顺序与添加的顺序一致 **/
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(set);
		set.remove("b");
		set.add("b");
		System.out.println(set);
	}
}
