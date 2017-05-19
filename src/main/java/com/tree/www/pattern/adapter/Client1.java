package com.tree.www.pattern.adapter;

/**
 * 缺省适配模式
 * 
 * 根据需要只实现必须的方法
 * 
 * @author pys
 *
 * @date 2016年4月12日 下午5:43:49
 */
public class Client1 {

	public static void main(String[] args) {
		Inter in1 = new Class1();
		Inter in2 = new Class2();
		Inter in3 = new Class3();

		in1.method1();
		in2.method2();
		in3.method3();
	}
}

interface Inter {

	void method1();

	void method2();

	void method3();
}

abstract class AbstractClass implements Inter {
	public void method1() {
	}

	public void method2() {

	}

	public void method3() {

	}
}

class Class1 extends AbstractClass {

	public void method1() {
		System.out.println("method1");
	}
}

class Class2 extends AbstractClass {

	public void method2() {
		System.out.println("method2");
	}
}

class Class3 extends AbstractClass {

	public void method3() {
		System.out.println("method3");
	}
}

