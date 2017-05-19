package com.tree.www.pattern.facade;

public class Camera {

	public void turnOn() {
		System.out.println("打开摄像头...");
	}

	public void turnOff() {
		System.out.println("关闭摄像头...");
	}

	// 转动摄像头是否看到人
	public boolean rotate(boolean c) {
		return c;
	}

}
