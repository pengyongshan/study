package com.tree.www.io.test;

import java.io.File;

/**
 * 列出指定目录下的文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test4 {
	public static void main(String[] args) {
		String fileName = "D:" + File.separator;// + "pys";
		File file = new File(fileName);
		String[] str = file.list();
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

		File[] files = file.listFiles();
		for (int i = 0; i < str.length; i++) {
			System.out.println(files[i]);
		}
	}

}
