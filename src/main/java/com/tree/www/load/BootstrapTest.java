package com.tree.www.load;

import java.net.URL;

// 根类加载器
public class BootstrapTest {

	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (URL url : urls) {
			System.out.println(url.toExternalForm());
		}
	}
}
