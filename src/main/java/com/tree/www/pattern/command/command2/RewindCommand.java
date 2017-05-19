package com.tree.www.pattern.command.command2;

/**
 * 倒带命令
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午10:53:17
 */
public class RewindCommand implements Command {

	private AudioPlayer myAudio;

	public RewindCommand(AudioPlayer player) {
		this.myAudio = player;
	}
	@Override
	public void execute() {
		myAudio.rewind();
	}

}
