package com.tree.www.net.server1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrazyMap<K, V> {

	public Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());
	
	public synchronized void removeByValue(V value){
		for(K key : map.keySet()) {
			if(map.get(key) == value) {
				map.remove(key);
				break;
			}
		}
	}
	
	public synchronized Set<V> valueSet() {
		Set<V> result = new HashSet<>();
		for (K key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}

	public synchronized K getKeyByValue(V val) {
		for (K key : map.keySet()) {
			if (map.get(key) == val || map.get(key).equals(val)) {
				return key;
			}
		}
		return null;
	}

	public synchronized V put(K key, V value) {
		for (V val : valueSet()) {
			if (val.equals(value) && val.hashCode() == value.hashCode()) {
				throw new RuntimeException("MyMap实例中不允许有重复value!");
			}
		}
		return map.put(key, value);
	}
}
