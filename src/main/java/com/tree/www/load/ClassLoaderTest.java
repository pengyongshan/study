package com.tree.www.load;

import com.sun.org.apache.xpath.internal.operations.String;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("com.tree.www.load.Tester"); // 仅仅是加载Tester类
		System.out.println("系统加载Tester类");
		Class.forName("com.tree.www.load.Tester"); // 到这才会初始化Tester
	}
}

class Tester {
	static {
		System.out.println("Tester类的初始化块...");
	}
}
