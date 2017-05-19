package com.tree.www.memory;

public class FinalizeTest {
	private static FinalizeTest ft = null;

	public void info() {
		System.out.println("测试资源清理的finalize()方法");
	}

	public static void main(String[] args) {
		new FinalizeTest();
		System.gc();
		System.runFinalization();
		ft.info();
	}

	@Override
	protected void finalize() throws Throwable {
		ft = this; // 可恢复-->可达
	}
}
