package com.tree.www.pattern.visitor.visitor1;

/**
 * 访问者模式——适用于数据结构相对稳定的系统
 * 
 * 表示一个作用于某对象结构中的各元素的操作。
 * 
 * 它使你可以在不改变各元素的类的前提 下定义作用于这些元素的新操作。
 * 
 * 访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。
 * 
 * 一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。
 * 
 * @author pys
 *
 * @date 2016年4月29日 上午10:00:21
 */
public class Client {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();

		os.add(new NodeA());
		os.add(new NodeB());

		Visitor visitor = new VisitorA();
		Visitor visitor2 = new VisitorB();
		os.action(visitor);
		os.action(visitor2);
	}
}
