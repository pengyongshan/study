package com.tree.www.pattern.singleton;

// 饿汉，类加载时就实例化了。——没有达到延迟加载的效果
public class SingletonPattern {

	private static final SingletonPattern SINGLE = new SingletonPattern();

	private SingletonPattern() {
		// 不能new
	}

	public static SingletonPattern getInstance() {
		return SINGLE;
	}
}
