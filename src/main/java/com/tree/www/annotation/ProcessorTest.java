package com.tree.www.annotation;

import java.lang.reflect.Method;

public class ProcessorTest {

	public static void process(String clazz) throws ClassNotFoundException {
		int passed = 0;
		int failed = 0;
		for (Method m : Class.forName(clazz).getMethods()) {
			if (m.isAnnotationPresent(Testable.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Exception ex) {
					System.out.println(ex.getCause());
					failed++;
				}
			}
		}
		System.out.println("共执行了" + (passed + failed) + "个方法，成功：" + passed + "个.");
	}

	public static void main(String[] args) throws Exception {
		ProcessorTest.process("MyTest");
	}
}
