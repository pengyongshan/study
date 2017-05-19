package com.tree.www.pattern.command.command2;

/**
 * 播放命令
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午10:53:17
 */
public class PlayCommand implements Command {

	private AudioPlayer myAudio;

	public PlayCommand(AudioPlayer player) {
		this.myAudio = player;
	}
	@Override
	public void execute() {
		myAudio.play();
	}

}
