package com.tree.www.pattern.template;

public class Honey extends Beverage {

	@Override
	protected void brew() {
		System.out.println("冲泡蜂蜜");
	}

	@Override
	protected void after() {
		System.out.println("搅拌");
	}

}
