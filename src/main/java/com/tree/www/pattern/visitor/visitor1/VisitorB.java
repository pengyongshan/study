package com.tree.www.pattern.visitor.visitor1;

// 具体访问者
public class VisitorB implements Visitor {

	@Override
	public void visit(NodeA node) {
		System.out.println(node.operationA());
	}

	@Override
	public void visit(NodeB node) {
		System.out.println(node.operationB());
	}
}
