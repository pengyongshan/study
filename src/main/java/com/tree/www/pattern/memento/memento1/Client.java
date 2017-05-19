package com.tree.www.pattern.memento.memento1;

/**
 * 备忘录模式——在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。
 * 
 * 这样以后就可将该对象恢复到原先保存的状态。
 * 
 * 白箱模式
 * 
 * @author pys
 *
 * @date 2016年4月25日 下午3:57:31
 */
public class Client {

	public static void main(String[] args) {
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		

		originator.setState("on");
		caretaker.saveMemento(originator.createMemento()); // 备份

		originator.setState("off");

		originator.restoreMemento(caretaker.retrieveMemento()); // 取出备份

		System.out.println(originator.getState());
		
	}
}
