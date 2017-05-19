package com.tree.www.pattern.visitor.visitor1;

// 具体节点类
public class NodeA extends Node {

	// 接受操作
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	// 节点A 特有的方法
	public String operationA() {
		return "NodeA";
	}
}
