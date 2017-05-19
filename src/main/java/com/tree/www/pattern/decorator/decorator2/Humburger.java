package com.tree.www.pattern.decorator.decorator2;

// 汉堡基类
public abstract class Humburger {

	protected String name;

	public String getName() {
		return name;
	}

	public abstract double getPrice();

	@Override
	public String toString() {
		return "name:" + getName() + "\tprice:" + getPrice();
	}
}
