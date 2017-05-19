package com.tree.www.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

// 读写属性文件
public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("pwd", "123456");
		props.setProperty("username", "pys");
		System.out.println(props);

		// 保存到文件
		props.store(new FileOutputStream("a.ini"), "comment Line");
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");

		// 将a.ini的key-value对加载到props2中
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}
}
