package com.tree.www.pattern.template;

public abstract class Beverage {

	/**
	 * 一个模板方法是定义在抽象类中的，把基本操作方法组合在一起形成一个总算法或一个总行为的方法。
	 * 一个抽象类可以有任意多个模板方法，而不限于一个。每一个模板方法都可以调用任意多个具体方法。
	 */
	public final void prepareBeverage() {
		boilWater();
		brew();
		pourIncup();
		doAddCondiments();
		after();
	}

	/** 基本方法 **/
	private void boilWater() { // 具体方法,子类并不实现或置换。
		System.out.println("烧开水");
	}

	private void pourIncup() { // 具体方法
		System.out.println("倒入杯中");
	}

	protected void doAddCondiments() { // 钩子方法， 子类复写扩展. 可以有默认实现，也可以缺省。
	}

	protected abstract void brew(); // 抽象方法，子类根据不同需求实现

	protected abstract void after(); // 抽象方法

}
