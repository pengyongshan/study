package com.tree.www.pattern.builder.builder2;

/**
 * 控制步骤
 * 
 * @author pys
 *
 * @date 2016年4月20日 下午4:06:31
 */
public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		director.getABenzModel().run();
		director.getBBenzModel().run();
		director.getABMWModel().run();
		director.getBBMWzModel().run();
	}
}
