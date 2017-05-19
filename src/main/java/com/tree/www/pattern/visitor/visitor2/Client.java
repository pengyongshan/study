package com.tree.www.pattern.visitor.visitor2;

/**
 * 抽象访问者(Visitor)角色：声明了一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。
 * 
 * 具体访问者(ConcreteVisitor)角色：实现抽象访问者所声明的接口，也就是抽象访问者所声明的各个访问操作。
 * 
 * 抽象节点(Node)角色：声明一个接受操作，接受一个访问者对象作为一个参数。
 * 
 * 具体节点(ConcreteNode)角色：实现了抽象节点所规定的接受操作。
 * 
 * 结构对象(ObjectStructure)角色：有如下的责任，可以遍历结构中的所有元素；如果需要，提供一个高层次的接口让访问者对象可以访问每一个元素；
 * 如果需要，可以设计成一个复合对象或者一个聚集，如List或Set。
 * 
 * @author pys
 *
 * @date 2016年4月29日 下午4:34:13
 */
public class Client {

	public static void main(String[] args) {

		EmployeeStructure es = getEsInit();

		IShowVisitor visitor = new ShowVisitor();
		es.accept(visitor);
		visitor.report();

		ITotalVisitor visitor2 = new TotalVisitor();
		es.accept(visitor2);
		visitor2.totalSalary();

	}

	public static EmployeeStructure getEsInit() {
		EmployeeStructure es = new EmployeeStructure();

		CommonEmployee zhangShan = new CommonEmployee();
		zhangShan.setJob("编程。");
		zhangShan.setName("张三");
		zhangShan.setSex(Employee.MALE);
		zhangShan.setSalary(8111);
		es.add(zhangShan);

		CommonEmployee lishi = new CommonEmployee();
		lishi.setJob("美工。");
		lishi.setName("李四");
		lishi.setSex(Employee.MALE);
		lishi.setSalary(10000);
		es.add(lishi);

		CommonEmployee xiaoliu = new CommonEmployee();
		xiaoliu.setJob("设计。");
		xiaoliu.setName("小六");
		xiaoliu.setSex(Employee.FEMALE);
		xiaoliu.setSalary(12000);
		es.add(xiaoliu);

		Manager laoda = new Manager();
		laoda.setName("老大");
		laoda.setSex(Employee.MALE);
		laoda.setSalary(50000);
		laoda.setPerformance("业绩杠杠滴");
		es.add(laoda);
		
		return es;
	}
}
