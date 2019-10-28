package com.tree.www.pattern.visitor.visitor2;

public class ShowVisitor implements IShowVisitor {

	private String info = "";

	@Override
	public void report() {
		System.out.println(this.info);
	}

	@Override
	public void visit(Manager manager) {
		info += this.getManagerInfo(manager);

	}

	@Override
	public void visit(CommonEmployee commonEmployee) {
		info += this.getCommonEmployeeInfo(commonEmployee);
	}

	private String getBaseInfo(Employee employee) {
		return "姓名：" + employee.getName() + "\t" +
				"性别：" + (employee.getSex() == Employee.MALE ? "男" : "女") +
				"薪水：" + employee.getSalary();
	}

	private String getManagerInfo(Manager manager) {
		return getBaseInfo(manager) + "\t业绩:" + manager.getPerformance() + "\n";
	}

	private String getCommonEmployeeInfo(CommonEmployee common) {
		return getBaseInfo(common) + "\t工作:" + common.getJob() + "\n";
	}

}
