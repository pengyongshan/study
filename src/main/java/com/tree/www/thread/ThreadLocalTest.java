package com.tree.www.thread;

public class ThreadLocalTest {

	public static void main(String[] args) {
		People people = new People("初始值");

		new MyTest(people, "线程甲").start();
		new MyTest(people, "线程乙").start();
	}
}

class People {
	private ThreadLocal<String> name = new ThreadLocal<>();

	public People(String str) {
		this.name.set(str);
		System.out.println("----" + this.name.get());
	}

	public String getName() {
		return name.get();
	}

	public void setName(String str) {
		this.name.set(str);
	}
}

class MyTest extends Thread {
	private People people;

	public MyTest(People people, String name) {
		super(name);
		this.people = people;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				people.setName(getName());
			}
			System.out.println(people.getName() + " 的i的值:" + i);
		}
	}
}
