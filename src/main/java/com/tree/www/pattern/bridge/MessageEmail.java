package com.tree.www.pattern.bridge;

public class MessageEmail implements MessageImplementor {

	@Override
	public void send(String msg, String toUser) {
		System.out.println("邮件消息：\t 发给" + toUser + "\t" + msg);
	}

}
