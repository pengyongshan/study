package com.tree.www.load.reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
@Annos(value = { @Anno })
public class ClassTest {
	private ClassTest() {

	}

	public ClassTest(String name) {
		System.out.println("执行有参数的构造器");
	}

	public void info() {
		System.out.println("执行无参的info()");
	}

	public void info(String str) {
		System.out.println("执行有参的info方法，参数为 " + str);
	}

	class Inner {
		// 测试用的内部类
	}

	public static void main(String[] args) throws Exception {
		Class<ClassTest> clazz = ClassTest.class;
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest的全部构造函数:");
		for (Constructor constructor : ctors) {
			System.out.println(constructor);
		}
		Constructor[] pubCtors = clazz.getConstructors();
		System.out.println("ClassTest的全部public构造函数:");
		for (Constructor constructor : pubCtors) {
			System.out.println(constructor);
		}

		Method[] methods = clazz.getMethods();
		System.out.println("ClassTest的全部public方法");
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("ClassTest带1个string参数的info方法：" + clazz.getMethod("info", String.class));

		Annotation[] anns = clazz.getAnnotations();
		System.out.println("ClassTest的全部注解:");
		for (Annotation annotation : anns) {
			System.out.println(annotation);
		}

		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("ClassTest的所有内部类:");
		for (Class<?> class1 : inners) {
			System.out.println(class1);
		}

		Class inClazz = Class.forName("com.qccr.www.load.ClassTest$Inner");
		System.out.println("inClazz对应类的外部类:" + inClazz.getDeclaringClass());
		System.out.println("ClassTest的包:" + clazz.getPackage());
		System.out.println("ClassTest的父类:" + clazz.getSuperclass());
	}
}

@interface Anno {
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
	Anno[] value();
}
