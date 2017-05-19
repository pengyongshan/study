package com.tree.www.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 输入输出重定向
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test13 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("hello");
		System.err.println("hello");
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);

		System.setOut(new PrintStream(new FileOutputStream(file, true)));
		System.setErr(new PrintStream(new FileOutputStream(file, true)));
		System.err.println("err");
		System.out.println("out");
	}

}
