package com.tree.www.pattern.command.command2;

/**
 * 请求者对象（键盘）
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午10:58:46
 */
public class Keypad {

	private Command command;

	public Keypad(Command command) {
		this.command = command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		this.command.execute();
	}
}
