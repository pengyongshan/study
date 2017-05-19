package com.tree.www.pattern.command.command1;

// 请求者对象
public class Invoker {
	/**
	 * 持有命令对象
	 */
	private Command command = null;

	public Invoker(Command command) {
		this.command = command;
	}

	public void action() {
		this.command.execute();
	}
}
