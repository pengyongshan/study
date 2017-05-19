package com.tree.www.pattern.decorator.decorator2;

// 加辣椒
public class Chilli extends Condiment {

	Humburger humburger;

	public Chilli(Humburger humburger) {
		this.humburger = humburger;
	}
	@Override
	public String getName() {
		return this.humburger.getName() + " 加辣椒";
	}

	@Override
	public double getPrice() {
		return this.humburger.getPrice(); // 辣椒免费
	}

}
