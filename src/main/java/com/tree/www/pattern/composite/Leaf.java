package com.tree.www.pattern.composite;

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
		String temp = "";
		for (int i = 0; i < depth; i++) {
			temp += "-";
		}
		System.out.println(temp + name);
	}

}
