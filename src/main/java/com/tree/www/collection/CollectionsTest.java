package com.tree.www.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsTest {

	public static void main(String[] args) {
		List num = new ArrayList();
		num.add(3);
		num.add(-13);
		num.add(32);
		num.add(23);
		num.add(3);
		num.add(-3);
		System.out.println("原始" + num);
		Collections.reverse(num); // 反转
		System.out.println("反转" + num);
		Collections.sort(num); // 排序
		System.out.println("排序" + num);
		Collections.shuffle(num); // 打乱
		System.out.println("随机" + num);

		System.out.println("最大值：" + Collections.max(num));
		System.out.println("最小值" + Collections.min(num));
		Collections.replaceAll(num, 3, 4);
		System.out.println(num);
		System.out.println("频率：" + Collections.frequency(num, 4));
		
		// 创建线程安全的集合对象
		Collection c = Collections.synchronizedCollection(new ArrayList());
		List list = Collections.synchronizedList(new ArrayList());
		Map map = Collections.synchronizedMap(new HashMap());
		Set set = Collections.synchronizedSet(new HashSet<>());

		// 生成不可变的集合
		List unmodifiable1 = Collections.emptyList();
		Set unmodifiable2 = Collections.singleton("ss");
		Map map2 = new HashMap<>();
		map2.put("数学", 100);
		map2.put("java", "77");
		Map unmodifiable3 = Collections.unmodifiableMap(map2);
		System.out.println(unmodifiable1);
		System.out.println(unmodifiable2);
		System.out.println(unmodifiable3);

		// unmodifiable1.add("11"); java.lang.UnsupportedOperationException
		// unmodifiable2.add("22");
		// unmodifiable3.put("33", "aa");
	}
}
