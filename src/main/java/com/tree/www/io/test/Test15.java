package com.tree.www.io.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据操作流 —— DataInputStream & DataOutputStream
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test15 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:" + File.separator + "pys" + File.separator + "hello.txt");
		char[] ch = { 'a', 'b', 'c' };
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		for (char c : ch) {
			out.write(c);
		}
		out.close();

		DataInputStream in = new DataInputStream(new FileInputStream(file));
		char[] c = new char[100];
		int count = 0;
		int temp;
		while ((temp = in.read()) != -1) {
			c[count++] = (char) temp;
		}
		in.close();
		System.out.println(new String(c, 0, count));
	}

}
