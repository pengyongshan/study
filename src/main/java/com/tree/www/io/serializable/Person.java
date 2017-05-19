package com.tree.www.io.serializable;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	// transient 不用序列化的加关键字
	private String name;

	private int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "姓名：" + name + ",年龄：" + age;
	}
}
