package com.tree.www.pattern.flyweight.flyweight2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory {

	private static FlyweightFactory factory = new FlyweightFactory();

	private FlyweightFactory() {
	}

	public static FlyweightFactory getInstance() {
		return factory;
	}

	private Map<String, Flyweight> flies = new HashMap<>();

	public Flyweight getFly(List<String> compositeStates) {
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();

		for (String string : compositeStates) {
			compositeFly.add(string, this.getFly(string));
		}

		return compositeFly;
	}

	public Flyweight getFly(String state) {
		return flies.computeIfAbsent(state, ConcreteFlyweight::new);
	}
}
