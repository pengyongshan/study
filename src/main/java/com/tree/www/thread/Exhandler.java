package com.tree.www.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class Exhandler {

	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExhandler());
		int a = 5 / 0;
		System.out.println("down");
	}

}

class MyExhandler implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + " 线程出现了异常 " + e);
	}
}
