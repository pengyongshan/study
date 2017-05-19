package com.tree.www.pattern.command.command2;

/**
 * 停止命令
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午10:53:17
 */
public class StopCommand implements Command {

	private AudioPlayer myAudio;

	public StopCommand(AudioPlayer player) {
		this.myAudio = player;
	}
	@Override
	public void execute() {
		myAudio.stop();
	}

}
