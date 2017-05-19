package com.tree.www.io.test;

import java.io.File;

/**
 * 删除文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test2 {
	public static void main(String[] args) {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		} else {
			System.out.println("文件不存在");
		}

	}

}
