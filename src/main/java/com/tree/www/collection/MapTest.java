package com.tree.www.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 判断key相等与HashSet一样。 equals() && hashCode(); value则equals().
 * 
 * 类似HashSet 尽量不要用可变对象作为key. 确实用到就尽量不修改
 * 
 * @author pys
 *
 * @date 2016年6月14日 下午7:55:53
 */
public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("a", null);
		map.put(null, 52);
		map.put("c", null);
		map.put("d", 53);
		System.out.println(map);
		for (Object key : map.keySet()) {
			System.out.println(key + "-->" + map.get(key));
		}
		System.out.println();
		for (Object obj : map.entrySet()) {
			Entry entry = (Entry) obj;
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
}
