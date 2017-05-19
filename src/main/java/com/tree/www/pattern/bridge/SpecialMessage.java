package com.tree.www.pattern.bridge;

public class SpecialMessage extends AbstractMessage {

	public SpecialMessage(MessageImplementor impl) {
		super(impl);
	}

	public void sendMessage(String msg, String toUser) {
		msg = "特急：" + msg;
		super.sendMessage(msg, toUser);
	}

	/**
	 * 扩展
	 * 
	 * @param messageId
	 * @return
	 */
	public Object hurry(String messageId) {
		System.out.println("催促：" + messageId);
		return null;
	}
}
