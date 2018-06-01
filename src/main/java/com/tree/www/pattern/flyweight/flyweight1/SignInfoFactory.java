package com.tree.www.pattern.flyweight.flyweight1;

import java.util.HashMap;
import java.util.Map;

public class SignInfoFactory {

	private static Map<String, SignInfo> pool = new HashMap<>();

	public static SignInfo getSignInfo(String key) {
		SignInfo signInfo;

		if (!pool.containsKey(key)) {
			System.out.println(key + "----建立对象，放入池中----");
			signInfo = new SignInfo4Pool(key);
			pool.put(key, signInfo);
		} else {
			signInfo = pool.get(key);
			System.out.println("----从池中取对象----");
		}
		return signInfo;
	}

	public static int getPoolSize() {
		return pool.size();
	}
}
