package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 字节输出流转字符输出流
 * 
 * 字节输入流转字符输入流
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test9 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);
		Writer out = new OutputStreamWriter(new FileOutputStream(file));
		out.write("hello, 您好");
		out.close();

		Reader in = new InputStreamReader(new FileInputStream(file));
		char[] c = new char[100];
		// int temp = 0;
		// int count = 0;
		// while ((temp = in.read()) != -1) {
		// c[count++] = (char) temp;
		// }
		in.read(c);
		in.close();
		System.out.println(new String(c));
	}
}
