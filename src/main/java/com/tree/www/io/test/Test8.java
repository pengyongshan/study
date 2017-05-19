package com.tree.www.io.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流向文件 写入、读取 字符串
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test8 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);
		Writer out = new FileWriter(file);
		out.write("hello, 您好");
		out.close();

		Reader in = new FileReader(file);
		char[] c = new char[100];
		int count = 0;
		int temp = 0;
		while ((temp = in.read()) != -1) {
			System.out.print(temp + ",");
			c[count++] = (char) temp;
			System.out.print(c[count - 1] + ";");
		}
		// in.read(c);
		in.close();
		System.out.println(new String(c, 0, count));
	}
}
