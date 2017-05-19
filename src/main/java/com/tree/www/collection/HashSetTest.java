package com.tree.www.collection;

import java.util.HashSet;
import java.util.Set;

/** equals为true 且hashCode 值相等 才算同一元素 **/
public class HashSetTest {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Test(1));
		set.add(new Test2(1)); // 交换顺序就是3个，equals是调用后添加的
		set.add(null);
		
		System.out.println(set);
	}
}

class Test {
	private int id;

	public Test(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public String toString() {
		return id + "";
	}

}

class Test2 {
	private int id;

	public Test2(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
