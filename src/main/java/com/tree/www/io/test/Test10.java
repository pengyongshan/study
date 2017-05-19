package com.tree.www.io.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 内容操作流 —— 一般使用来生成一些临时信息采用的，这样可以避免删除的麻烦。
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test10 {
	public static void main(String[] args) throws IOException {
		String str = "HELLO";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		int temp = 0;
		while ((temp = in.read()) != -1) {
			char ch = (char) temp;
			out.write(Character.toLowerCase(ch));
		}

		String outStr = out.toString();
		in.close();
		out.close();
		System.out.println(outStr);
	}
}
