package com.tree.www.pattern.prototype;

public class Mail implements Cloneable {

	private AdvTemplate advTemplate;

	private String receiver;

	private String receiveName;

	private String tail;

	public Mail(AdvTemplate advTemplate) {
		this.advTemplate = advTemplate;
	}

	public AdvTemplate getAdvTemplate() {
		return advTemplate;
	}

	public void setAdvTemplate(AdvTemplate advTemplate) {
		this.advTemplate = advTemplate;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	@Override
	protected Mail clone() throws CloneNotSupportedException {

		Mail mail = (Mail) super.clone();
		//mail.advTemplate = this.advTemplate.clone();// 不加就是浅拷贝
		return mail;
	}
}
