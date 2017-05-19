package com.tree.www.pattern.bridge;

public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String msg, String toUser) {
		System.out.println("SMS消息：\t 发给" + toUser + "\t" + msg);
	}

}
