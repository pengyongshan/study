package com.tree.www.memory;

public class GcTest {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			new GcTest();
		}
		System.gc(); // 通知程序进行回收处理。不一定能即时。
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("开始执行垃圾回收...");
	}
}
