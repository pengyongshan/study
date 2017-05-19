package com.tree.www.load;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器:" + systemLoader);
		// 获取系统类加载器的加载路径
		Enumeration<URL> eml = systemLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}

		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器:" + extensionLoader);
		System.out.println("扩展类加载器的加载路径:" + System.getProperty("java.ext.dirs"));

		// null 因为根加载器不是java实现的
		System.out.println("扩展类加载器的parent:" + extensionLoader.getParent());
	}
}
