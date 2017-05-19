package com.tree.www.pattern.visitor.visitor2;

public class Manager extends Employee {

	private String performance;

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPerformance() {
		return performance;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
