package com.tree.www.pattern.command.command2;

/**
 * 用户--客户端对象
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午11:03:30
 */
public class Client {

	public static void main(String[] args) {
		AudioPlayer player = new AudioPlayer();

		Command playCommand = new PlayCommand(player);
		Command rewindCommand = new RewindCommand(player);
		Command stopCommand = new StopCommand(player);

		MacroCommand macroCommand = new MacroAudioCommand();
		macroCommand.add(playCommand);
		macroCommand.add(stopCommand);
		macroCommand.add(stopCommand);
		macroCommand.add(rewindCommand);

		Keypad keypad = new Keypad(playCommand);
		keypad.action();

		keypad.setCommand(rewindCommand);
		keypad.action();

		keypad.setCommand(stopCommand);
		keypad.action();

		keypad.setCommand(macroCommand);
		keypad.action();
	}
}
