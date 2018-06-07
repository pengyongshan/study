package com.tree.www.pattern.iterator.iterator1;

import java.util.List;

public class ConcreteAggregate implements Aggregate {

	private List<Object> list;

	public ConcreteAggregate(List<Object> list) {
		this.list = list;
	}
	@Override
	public void add(Object obj) {
		list.add(obj);
	}

	@Override
	public void remove(Object obj) {
		list.remove(obj);
	}

	@Override
	public Iterator iterator() {
		return new ConcreteIterator(list);
	}

}
