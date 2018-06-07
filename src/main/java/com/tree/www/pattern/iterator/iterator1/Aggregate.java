package com.tree.www.pattern.iterator.iterator1;

// 模拟集合接口 增删查（抽象容器）
public interface Aggregate {

	void add(Object obj);

	void remove(Object obj);

	Iterator iterator();
}
