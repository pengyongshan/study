package com.tree.www.io.test;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件夹
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test3 {
	public static void main(String[] args) {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello" + File.separator + "ss.txt";
		File file = new File(fileName);
		if (!file.getParentFile().isDirectory()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
