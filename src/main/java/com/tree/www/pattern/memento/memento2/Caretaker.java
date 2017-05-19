package com.tree.www.pattern.memento.memento2;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {

	private Map<String, IMemento> map = new HashMap<>();

	public IMemento retrieveMemento(String point) {
		return this.map.get(point);
	}

	public void saveMemento(String point, IMemento memento) {
		this.map.put(point, memento);
	}
}
