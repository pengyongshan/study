package com.tree.www.pattern.decorator.decorator1;

// 初始装饰者
public class Person implements Human {

	@Override
	public void wearClothes() {
		System.out.println("穿啥呢...");
	}

	@Override
	public void walkToWhere() {
		System.out.println("去哪呢...");
	}

}
