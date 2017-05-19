package com.tree.www.pattern.facade;

public class Sensor {

	public void activate() {
		System.out.println("开启传感器...");
	}

	public void deactive() {
		System.out.println("关闭传感器...");
	}

	// 是否有人触发感应器
	public boolean trigger(boolean s) {
		return s;
	}

}
