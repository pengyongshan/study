package com.tree.www.io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test12 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		PrintStream print = new PrintStream(new FileOutputStream(new File(fileName)));
		print.println(true);
		print.println("hello");

		// 格式化
		String name = "pys";
		int age = 22;
		print.printf("姓名：%s. 年龄：%d", name, age);
		print.close();
	}
}
