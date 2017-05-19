package com.tree.www.load;

public class CompileConstantTest {
	public static void main(String[] args) {
		// 不会导致MyTest的初始化，在编译期compileConstant(宏变量)就确定了。
		System.out.println(MyTest.compileConstant);
		// 必须运行时才可以确定 通过该类来访问类变量 必须保留对MyTest类的类变量的引用
		// 会导致该类初始化
		System.out.println(MyTest.time);
	}
}

class MyTest {
	static {
		System.out.println("静态初始化块....");
	}

	static final String compileConstant = "特维轮";
	static final long time = System.currentTimeMillis();
}

