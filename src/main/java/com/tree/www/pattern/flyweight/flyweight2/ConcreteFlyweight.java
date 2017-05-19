package com.tree.www.pattern.flyweight.flyweight2;

// 具体享元角色
public class ConcreteFlyweight implements Flyweight {

	private String intrinsicState; // 内蕴状态

	public ConcreteFlyweight(String intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	/**
	 * 外蕴状态作为参数传入方法中，改变方法的行为， 但是并不改变对象的内蕴状态。
	 */
	public void operation(String state) {
		System.out.println("内蕴状态：" + this.intrinsicState);
		System.out.println("外蕴状态：" + state);
	}

}
