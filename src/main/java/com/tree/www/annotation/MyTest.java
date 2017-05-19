package com.tree.www.annotation;

public class MyTest {

	@Testable
	public static void m1() {
		System.out.println("m1成功");
	}

	public static void m2() {
		System.out.println("m2成功");
	}

	@Testable
	public static void m3() {
		throw new IllegalArgumentException("m3参数错误");
	}

	public static void m4() {
		throw new IllegalArgumentException("m4参数错误");
	}

	@Testable
	public static void m5() {
		System.out.println("m5");
	}

	public static void m6() {
		System.out.println("m6");
	}

	@Testable
	public static void m7() {
		System.out.println("m7");
	}

}
