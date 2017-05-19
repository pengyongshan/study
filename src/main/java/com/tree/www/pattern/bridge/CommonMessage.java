package com.tree.www.pattern.bridge;

public class CommonMessage extends AbstractMessage {

	public CommonMessage(MessageImplementor impl) {
		super(impl);
	}

	public void sendMessage(String msg, String toUser) {
		super.sendMessage(msg, toUser);
	}
}
