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

	private Map<String, Flyweight> flies = new HashMap<String, Flyweight>();

	public Flyweight getFly(List<String> compositeStates) {
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();

		for (String string : compositeStates) {
			compositeFly.add(string, this.getFly(string));
		}

		return compositeFly;
	}

	public Flyweight getFly(String state) {
		Flyweight flyweight = flies.get(state);
		if(flyweight == null){
			flyweight = new ConcreteFlyweight(state);
			flies.put(state, flyweight);
		}
		return flyweight;
	}
}
