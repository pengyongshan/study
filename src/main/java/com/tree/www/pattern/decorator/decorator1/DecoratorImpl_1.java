package com.tree.www.pattern.decorator.decorator1;

public class DecoratorImpl_1 extends Decorator {

	public DecoratorImpl_1(Human human) {
		super(human);
	}

	public void wearClothes() {
		super.wearClothes();
		goHome();
	}

	public void walkToWhere() {
		super.walkToWhere();
		findMap();
	}

	public void findMap() {
		System.out.println("找地图...");
	}

	public void goHome() {
		System.out.println("进房子...");
	}
}
