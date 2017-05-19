package com.tree.www.pattern.facade;

public class Alarm {

	public void active() {
		System.out.println("开启警报器...");
	}

	public void deactive() {
		System.out.println("关闭警告器...");
	}

	// 有人触发警告
	public boolean ring(boolean a) {
		return a;
	}
}
