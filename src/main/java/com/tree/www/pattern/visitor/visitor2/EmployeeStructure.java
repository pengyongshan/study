package com.tree.www.pattern.visitor.visitor2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStructure {

	private List<Employee> list = new ArrayList<Employee>();

	public void accept(IVisitor visitor) {
		for (Employee employee : list) {
			employee.accept(visitor);
		}
	}

	public void add(Employee employee) {
		list.add(employee);
	}
}
