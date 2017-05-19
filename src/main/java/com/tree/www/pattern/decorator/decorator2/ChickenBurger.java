package com.tree.www.pattern.decorator.decorator2;

// 初始鸡腿堡
public class ChickenBurger extends Humburger {

	public ChickenBurger() {
		this.name = "鸡腿堡";
	}

	@Override
	public double getPrice() {
		return 10;
	}
}
