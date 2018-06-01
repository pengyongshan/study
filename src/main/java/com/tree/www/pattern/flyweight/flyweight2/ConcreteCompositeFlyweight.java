package com.tree.www.pattern.flyweight.flyweight2;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元角色
 * 
 * @author pys
 *
 * @date 2016年4月22日 下午2:52:05
 */
public class ConcreteCompositeFlyweight implements Flyweight {

	private Map<String, Flyweight> flies = new HashMap<>();

	// 增加一个新的单纯享元到聚集中
	public void add(String key, Flyweight fly) {
		flies.put(key, fly);
	}

	@Override
	public void operation(String state) {
		Flyweight fly;
		for (String string : flies.keySet()) {
			fly = flies.get(string);
			fly.operation(state);
		}
	}

}
