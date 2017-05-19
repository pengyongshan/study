package com.tree.www.pattern.memento.memento1;

public class Memento {

	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
