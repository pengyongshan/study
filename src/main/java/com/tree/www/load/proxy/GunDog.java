package com.tree.www.load.proxy;

public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("dog");
	}

	@Override
	public void run() {
		System.out.println("dog run");
	}

}
