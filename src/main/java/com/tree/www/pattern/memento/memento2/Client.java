package com.tree.www.pattern.memento.memento2;

// 黑箱--只有发起人才能更改备份状态, 多状态多点备份
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();

		originator.setState1("AAA1");
		originator.setState2("AAA2");
		originator.setState3("AAA3");
		caretaker.saveMemento("001", originator.createMemento()); // 备份
		System.out.println("001：" + originator);

		originator.setState1("BBB1");
		originator.setState2("BBB2");
		originator.setState3("BBB3");
		caretaker.saveMemento("002", originator.createMemento());
		System.out.println("002：" + originator);

		originator.setState1("CCC1");
		originator.setState2("CCC2");
		originator.setState3("CCC3");
		caretaker.saveMemento("003", originator.createMemento());
		System.out.println("003：" + originator);

		originator.restoreMemento(caretaker.retrieveMemento("002")); // 取出备份

		System.out.println("取出002备份：" + originator);

		originator.restoreMemento(caretaker.retrieveMemento("001")); // 取出备份

		System.out.println("取出001备份：" + originator);
	}
}
