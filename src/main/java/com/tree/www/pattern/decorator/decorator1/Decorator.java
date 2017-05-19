package com.tree.www.pattern.decorator.decorator1;

// 装饰者
public abstract class Decorator implements Human {

	private Human human;

	public Decorator(Human human) {
		this.human = human;
	}

	public void wearClothes() {
		human.wearClothes();
	}

	public void walkToWhere() {
		human.walkToWhere();
	}
}
