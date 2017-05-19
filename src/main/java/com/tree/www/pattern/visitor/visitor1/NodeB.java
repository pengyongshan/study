package com.tree.www.pattern.visitor.visitor1;

// 具体节点类
public class NodeB extends Node {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String operationB() {
		return "NodeB";
	}

}
