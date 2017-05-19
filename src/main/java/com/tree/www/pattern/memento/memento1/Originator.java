package com.tree.www.pattern.memento.memento1;

public class Originator {

	private String state;

	public Memento createMemento() {
		return new Memento(this.state);
	}

	public void restoreMemento(Memento memento) {
		this.state = memento.getStatus();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("当前状态：" + state);
	}

}
