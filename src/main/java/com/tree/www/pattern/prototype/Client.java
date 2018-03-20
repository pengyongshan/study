package com.tree.www.pattern.prototype;

import java.util.Random;

/**
 * 原型模式——浅拷贝只拷贝基本类型对象，与原型共用其他对象的引用。深拷贝其它对象也需要克隆。
 * 
 * @author pys
 *
 * @date 2016年4月27日 下午4:40:53
 */
public class Client {

	private final static int COUNT = 6;

	public static void main(String[] args) throws CloneNotSupportedException {

		Mail smail = new Mail(new AdvTemplate());

		smail.setTail("xx银行版权所有");

		for (int i = 0; i < COUNT; i++) {
			Mail mail = smail.clone();
			mail.setReceiveName(getRandomString(5) + "先生/女士");
			mail.setReceiver(getRandomString(5) + "@" + getRandomString(8) + ".com");
			sendMail(mail);
		}
	}

	private static void sendMail(Mail mail) {
		System.out.println("收件人：" + mail.getReceiver() + "\n标题：" + mail.getAdvTemplate().getAdvSubject() + "\n内容："
				+ mail.getReceiveName() + ",您好。" + mail.getAdvTemplate().getAdvContext() + "\n末尾:" + mail.getTail());
		System.out.println();
	}

	private static String getRandomString(int length) {
		String source = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

		StringBuilder sb = new StringBuilder();

		Random rand = new Random();

		for (int i = 0; i < length; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}

		return sb.toString();
	}
}
