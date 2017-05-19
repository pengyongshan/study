package com.tree.www.pattern.singleton;

// 懒汉
public class SingletonPattern2 {

	private static SingletonPattern2 SINGLE;

	private SingletonPattern2() {
		// 不能new
	}

	// 同步防止多线程错误
	public synchronized static SingletonPattern2 getInstance() {
		if (SINGLE == null) {
			SINGLE = new SingletonPattern2();
		}
		return SINGLE;
	}
}
