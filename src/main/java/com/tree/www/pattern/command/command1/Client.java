package com.tree.www.pattern.command.command1;

/**
 * 命令模式
 * 
 * ● 客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。
 * 
 * ● 命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 * 
 * ●具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute(
 * ) 方法通常叫做执行方法。
 * 
 * ● 请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
 * 
 * ● 接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 * 
 * @author pys
 *
 * @date 2016年4月20日 下午7:20:13
 */
public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();

		Command command = new ConcreteCommand(receiver);

		Invoker invoker = new Invoker(command);

		invoker.action();
	}
}
