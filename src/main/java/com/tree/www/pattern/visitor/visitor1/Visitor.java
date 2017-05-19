package com.tree.www.pattern.visitor.visitor1;

// 抽象访问者
public interface Visitor {

	public void visit(NodeA node);

	public void visit(NodeB node);
}
