package com.tree.www.pattern.builder.builder2;

public class BenzModel extends CarModel {

	@Override
	protected void start() {
		System.out.println("奔驰启动...");

	}

	@Override
	protected void stop() {
		System.out.println("奔驰停车...");

	}

	@Override
	protected void alarm() {
		System.out.println("奔驰鸣笛...");

	}

	@Override
	protected void engineBoom() {
		System.out.println("奔驰引擎...");

	}

}
