package com.tree.www.pattern.command.command2;

/**
 * 接收者角色(录音机)
 * 
 * @author pys
 *
 * @date 2016年4月21日 上午10:49:16
 */
public class AudioPlayer {

	public void play() {
		System.out.println("播放...");
	}

	public void rewind() {
		System.out.println("倒带...");
	}

	public void stop() {
		System.out.println("停止...");
	}
}
