package com.tree.www.pattern.bridge.bridge1;

public class MessagePhone implements MessageImplementor {

	@Override
	public void send(String msg, String toUser) {
		System.out.println("手机消息：\t 发给" + toUser + "\t" + msg);
	}
}
