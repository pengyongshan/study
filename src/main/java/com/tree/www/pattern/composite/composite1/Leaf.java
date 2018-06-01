package com.tree.www.pattern.composite.composite1;

public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		System.out.println("Can't add to a leaf.");

	}

	@Override
	public void remove(Component component) {
		System.out.println("Can't remove from a leaf.");
	}

	@Override
	public void display(int depth) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			temp.append("-");
		}
		System.out.println(temp + name);
	}

}
