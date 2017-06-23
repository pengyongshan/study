package com.tree.www.test;

import java.util.Map;

public class SystemTest {
	public static void main(String[] args) throws Exception {
		// 获取系统的环境变量
		Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + " ---> " + env.get(name));
		}
		System.out.println(System.getenv("JAVA_HOME"));
		// 获取系统属性并保存到props.txt中。
		// Properties props = System.getProperties();
		// props.store(new FileOutputStream("props.txt"), "System Properties");
		System.out.println("--------" + System.getProperty("os.name"));

		// IdentityHashcodeTest
		String s1 = "java";
		String s2 = "java";
		System.out.println(s1.hashCode() + "-" + s2.hashCode());

		// 根据对象地址的绝对hashcode值
		System.out.println(System.identityHashCode(s1) + "-" + System.identityHashCode(s2));

		String s3 = "java";
		String s4 = "java";

		// 表示s3 、s4是同一个对象
		System.out.println(System.identityHashCode(s3) + "-" + System.identityHashCode(s4));

		System.out.println(System.currentTimeMillis()); // 微秒
		System.out.println(System.nanoTime()); //计算差值
	}
}
