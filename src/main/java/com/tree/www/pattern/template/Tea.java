package com.tree.www.pattern.template;

public class Tea extends Beverage {

	@Override
	protected void brew() {
		System.out.println("冲泡茶叶");
	}

	@Override
	protected void doAddCondiments() {
		System.out.println("添加柠檬");
	}

	@Override
	protected void after() {
		System.out.println("wait a minute");
	}
}
