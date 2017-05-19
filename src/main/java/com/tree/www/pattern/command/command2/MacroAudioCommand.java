package com.tree.www.pattern.command.command2;

import java.util.ArrayList;
import java.util.List;

// 命令集——宏命令
public class MacroAudioCommand implements MacroCommand {

	private List<Command> commands = new ArrayList<Command>();

	@Override
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

	@Override
	public void add(Command command) {
		commands.add(command);
	}

	@Override
	public void remove(Command command) {
		commands.remove(command);
	}

}
