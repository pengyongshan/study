package com.tree.www.pattern.prototype;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Mail mail = new Mail(new AdvTemplate());
		Mail cloneMail = mail.clone();

		// 浅拷贝，只拷贝了对象引用。
		// cloneMail.getAdvTemplate().setAdvSubject("bbbb00");
		// System.out.println(mail.getAdvTemplate().getAdvSubject());
		
		cloneMail.getAdvTemplate().setAdvSubject("bbbb00");
		System.out.println(mail.getAdvTemplate().getAdvSubject());

	}
}
