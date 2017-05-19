package com.tree.www.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	// 每个key只持有对象的弱引用。垃圾回收key对应的实际对象后，后自动删除key-value对
	public static void main(String[] args) {
		Map map = new WeakHashMap();
		map.put(new String("语文"), "良好");
		map.put(new String("数学"), "良好");
		map.put(new String("英文"), "良好");
		map.put(null, "良好");
		map.put("java", "...");
		System.out.println(map);
		System.gc();
		System.runFinalization();
		System.out.println(map);
		// 不要让key引用的对象具有强引用，否则就没有使用WeakHashMap的意义
	}
}
