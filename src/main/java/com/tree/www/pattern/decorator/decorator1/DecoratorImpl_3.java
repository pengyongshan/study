package com.tree.www.pattern.decorator.decorator1;

public class DecoratorImpl_3 extends Decorator {

	public DecoratorImpl_3(Human human) {
		super(human);
	}

	public void wearClothes() {
		super.wearClothes();
		findClothes();
	}

	public void walkToWhere() {
		super.walkToWhere();
		findTheTarget();
	}

	public void findTheTarget() {
		System.out.println("找到目的地上海...");
	}

	public void findClothes() {
		System.out.println("找到衣服...");
	}
}
