package com.tree.www.pattern.prototype;

public class AdvTemplate implements Cloneable {

	private String advSubject = "XX银行国庆抽奖活动";

	private String advContext = "国庆抽奖活动";

	public String getAdvContext() {
		return advContext;
	}

	public String getAdvSubject() {
		return advSubject;
	}

	public void setAdvSubject(String advSubject) {
		this.advSubject = advSubject;
	}

	public void setAdvContext(String advContext) {
		this.advContext = advContext;
	}

	@Override
	protected AdvTemplate clone() throws CloneNotSupportedException {
		return (AdvTemplate) super.clone();
	}
}
