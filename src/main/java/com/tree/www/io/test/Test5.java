package com.tree.www.io.test;

import java.io.File;

/**
 * 列出指定目录下的全部文件(包括子文件夹)
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test5 {
	public static void main(String[] args) {
		String fileName = "D:" + File.separator + "pys";
		File file = new File(fileName);
		print(file);
		System.out.println(Integer.MAX_VALUE);
	}

	private static void print(File file) {
		if (file != null) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						print(files[i]);
					}
				}
			} else {
				System.out.println(file);
			}
		}
	}

}
