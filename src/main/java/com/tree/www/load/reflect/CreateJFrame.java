package com.tree.www.load.reflect;

import java.lang.reflect.Constructor;

import javax.swing.JFrame;

public class CreateJFrame {

	public static void main(String[] args) throws Exception {
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		Constructor constructor = jframeClazz.getConstructor(String.class); // 指定构造器
		JFrame obj = (JFrame) constructor.newInstance("测试窗口");
		// obj.setVisible(true);
		System.out.println(obj);
	}
}
