package com.tree.www.load.reflect;

import java.lang.reflect.Field;

// 访问成员变量 基础类型setXXX 引用set
public class FieldTest {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class<Person> clazz = Person.class;
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true); // 取消访问权限检查.public 类型的就不用
		nameField.set(p, "pys");
		Field ageField = clazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.setInt(p, 12);
		int age = ageField.getInt(p);
		String name = (String) nameField.get(p);
		System.out.println(age + " " + name);
		System.out.println(p);

	}
}

class Person {
	private String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
