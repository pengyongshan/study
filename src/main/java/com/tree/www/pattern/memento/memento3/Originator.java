package com.tree.www.pattern.memento.memento3;

import com.tree.www.pattern.memento.memento2.IMemento;

public class Originator {

	public String state;

	public void changeState(String state) {
		this.state = state;
		System.out.println("状态改变为：" + state);
	}

	public IMemento createMemento() {
		return new Memento(this);
	}

	public void restoreMemento(IMemento me) {
		Memento m = (Memento) me;
		changeState(m.state);
	}

	private class Memento implements IMemento {
		private String state;

		private Memento(Originator originator) {
			this.state = originator.state;
		}
	}
}
