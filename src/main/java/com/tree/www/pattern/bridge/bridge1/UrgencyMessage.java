package com.tree.www.pattern.bridge.bridge1;

public class UrgencyMessage extends AbstractMessage {

	public UrgencyMessage(MessageImplementor impl) {
		super(impl);
	}

	public void sendMessage(String msg, String toUser) {
		msg = "加急：" + msg;
		super.sendMessage(msg, toUser);
	}

	/**
	 * 扩展
	 * 
	 * @param messageId
	 * @return
	 */
	public void wacth(String messageId) {
		System.out.println("监控：" + messageId);
	}
}
