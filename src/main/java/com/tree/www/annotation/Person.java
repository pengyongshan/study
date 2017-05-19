package com.tree.www.annotation;

import java.io.Serializable;

@Persistent(table = "person_inf")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8226451420806369070L;

	@Id(column = "person_id", type = "integer", generator = "identity")
	private int id;

	@Property(column = "person_name", type = "string")
	private String name;

	@Property(column = "person_age", type = "integer")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
