package com.tree.www.pattern.command.command2;

/**
 * 宏命令
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午11:30:39
 */
public interface MacroCommand extends Command {

	public void add(Command command);

	public void remove(Command command);

}
