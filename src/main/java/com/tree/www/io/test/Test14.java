package com.tree.www.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * BufferReader & Scanner
 * 
 * BufferedReader只能接受字符流的缓冲区，因为每一个中文需要占据两个字节，所以需要将System.in这个字节输入流变为字符输入流
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test14 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入内容:");
		str = buf.readLine();
		System.out.println("你输入：" + str);
		buf.close();

		File file = new File("D:" + File.separator + "pys" + File.separator + "hello.txt");
		Scanner scan = new Scanner(file);
		System.out.println(scan.next());
	}

}
