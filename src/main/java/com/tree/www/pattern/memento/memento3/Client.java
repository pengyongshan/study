package com.tree.www.pattern.memento.memento3;

import com.tree.www.pattern.memento.memento2.IMemento;

// 自述历史
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator();

		originator.changeState("state 0");

		IMemento memento = originator.createMemento();

		originator.changeState("status 1");

		originator.restoreMemento(memento);
	}
}
