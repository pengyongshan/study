package com.tree.www.pattern.memento.memento1;

public class Caretaker {

	private Memento memento;

	public Memento retrieveMemento() {
		return this.memento;
	}

	public void saveMemento(Memento memento) {
		this.memento = memento;
	}
}
