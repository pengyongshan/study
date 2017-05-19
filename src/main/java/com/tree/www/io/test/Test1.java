package com.tree.www.io.test;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test1 {
	public static void main(String[] args) {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
