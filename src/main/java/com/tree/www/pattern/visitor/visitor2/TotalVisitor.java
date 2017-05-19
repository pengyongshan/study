package com.tree.www.pattern.visitor.visitor2;

public class TotalVisitor implements ITotalVisitor {

	private final static int MANAGER_COEFFICIENT = 5;

	private final static int COMMONEMPLOYEE_MANAGER_COEFFICIENT = 2;

	private int commonTotalSalary = 0;

	private int managerTotalSalaty = 0;

	@Override
	public void visit(Manager manager) {
		this.calManagerSalaty(manager.getSalary());
	}

	@Override
	public void visit(CommonEmployee commonEmployee) {
		this.calCommonSalary(commonEmployee.getSalary());
	}

	@Override
	public void totalSalary() {
		System.out.println("本公司的本月工资总和：" + (this.managerTotalSalaty + this.commonTotalSalary));
	}

	private void calManagerSalaty(int salary) {
		this.managerTotalSalaty += salary * MANAGER_COEFFICIENT;
	}

	private void calCommonSalary(int salary) {
		this.commonTotalSalary += salary * COMMONEMPLOYEE_MANAGER_COEFFICIENT;
	}

}
