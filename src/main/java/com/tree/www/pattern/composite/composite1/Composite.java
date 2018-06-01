package com.tree.www.pattern.composite.composite1;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

	private List<Component> children = new ArrayList<Component>();

	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		children.add(component);
	}

	@Override
	public void remove(Component component) {
		children.remove(component);
	}

	@Override
	public void display(int depth) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			temp.append("-");
		}
		System.out.println(temp + name);
		for (Component component : children) {
			component.display(depth + 2);
		}
	}
}
