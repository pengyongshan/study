package com.tree.www.pattern.bridge.bridge1;

/**
 * 桥梁模式 ---改继承为聚合 解耦合。
 * 
 * 把抽象化和实例化脱耦，是两者可以自由的变化和组合. 抽象委托实例
 * 
 * 本例就是把消息类型和发消息的方式分离互相扩展互不干涉。用继承的话每一种组合都要一个子类。 3*3变成3+3。
 * 
 * @author pys
 *
 * @date 2016年4月13日 下午2:52:21
 */
public class Client {

	public static void main(String[] args) {
		// sms 发普通消息
		AbstractMessage msg = new CommonMessage(new MessageSMS());
		msg.sendMessage("加班申请", "李总");

		// 邮件发加急消息
		msg = new UrgencyMessage(new MessageEmail());
		msg.sendMessage("请假申请", "李总");
		// 扩展功能
		((UrgencyMessage) msg).wacth("11");

		// 手机发特急消息
		 msg = new SpecialMessage(new MessagePhone());
		 msg.sendMessage("请假", "李总");
		((SpecialMessage) msg).hurry("11");
	}
}
