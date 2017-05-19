package com.tree.www.load.proxy;

import java.util.Date;

import javax.swing.JFrame;

// 使用泛型避免强制类型转换
public class ObjectFactory {

	public static <T> T getInstance(Class<T> cls) throws InstantiationException, IllegalAccessException {
		return cls.newInstance();
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Date d = ObjectFactory.getInstance(Date.class);
		JFrame jf = ObjectFactory.getInstance(JFrame.class);
	}
}
