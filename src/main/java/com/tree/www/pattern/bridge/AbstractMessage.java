package com.tree.www.pattern.bridge;

public abstract class AbstractMessage {

	MessageImplementor implementor;

	public AbstractMessage(MessageImplementor impl) {
		this.implementor = impl;
	}

	public void sendMessage(String msg, String toUser) {
		this.implementor.send(msg, toUser);
	}
}
