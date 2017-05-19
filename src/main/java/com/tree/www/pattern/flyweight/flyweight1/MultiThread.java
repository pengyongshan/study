package com.tree.www.pattern.flyweight.flyweight1;

public class MultiThread extends Thread {

	private SignInfo signInfo;

	public MultiThread(SignInfo signInfo) {
		this.signInfo = signInfo;
	}

	public void run() {
		// 设置为一致 如果不一致说明数据错乱了 线程不安全
		if (!signInfo.getId().equals(signInfo.getLocation())) {
			System.out.println("线程不安全：" + signInfo.getId() + "\t" + signInfo.getLocation());
		}
	}

}
