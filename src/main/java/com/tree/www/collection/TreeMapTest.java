package com.tree.www.collection;

import java.util.TreeMap;

public class TreeMapTest {

	/**
	 * TreeMap中的元素是有序的.
	 * 
	 * 默认自然排序即比较对象的compareTo方法,TreeMap的key元素必须实现Comparable接口，或传入定制排序的匿名内部类.
	 * 
	 * TreeMap key-compareTo返回0 元素相等无法加入
	 * 
	 * 与HashMap相比 多了访问第一个，前一个，后一个，最后一个的一些方法，还有截取子字符串的
	 */
	public static void main(String[] args) {
		TreeMap map = new TreeMap();
		map.put(new T(3), "aaa");
		map.put(new T(-5), "bbb");
		map.put(new T(9), "ccc");
		map.put(new T(-15), "ddd");
		System.out.println(map);
		System.out.println(map.firstKey() + "," + map.firstEntry());
		System.out.println(map.lastEntry());
		System.out.println(map.higherKey(new T(3)));
		System.out.println(map.lowerKey(new T(3)));
		System.out.println(map.subMap(new T(-5), true, new T(9), true));
	}
}

class T implements Comparable {

	int count;

	public T(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == T.class) {
			return this.count == ((T) obj).count;
		}
		return false;
	}

	public int compareTo(Object obj) {
		T t = (T) obj;
		return t.count > this.count ? -1 : (t.count == this.count ? 0 : 1);
	}

	@Override
	public String toString() {
		return "T[count:" + count + "]";
	}
}
