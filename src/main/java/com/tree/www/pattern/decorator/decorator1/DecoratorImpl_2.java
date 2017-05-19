package com.tree.www.pattern.decorator.decorator1;

public class DecoratorImpl_2 extends Decorator {

	public DecoratorImpl_2(Human human) {
		super(human);
	}

	public void wearClothes() {
		super.wearClothes();
		findClothespress();
	}

	public void walkToWhere() {
		super.walkToWhere();
		findPlace();
	}

	public void findPlace() {
		System.out.println("在地图上找目的地...");
	}

	public void findClothespress() {
		System.out.println("在家找衣服...");
	}
}
