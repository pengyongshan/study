package com.tree.www.io.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 回退流
 * 
 * @author pys
 *
 * @date 2016年4月14日 下午5:52:06
 */
public class Test21 {
	public static void main(String[] args) throws IOException {
		String str = "hello, pys";
		PushbackInputStream push = null;
		ByteArrayInputStream bat = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bat);
		int temp = 0;
		while ((temp = push.read()) != -1) {
			if (temp == ',') {
				push.unread(temp);
				System.out.print("(回退" + (char) temp + ")");
				push.read();
			} else {
				System.out.print((char) temp);
			}
		}
		push.close();
		bat.close();
		System.out.println();
	}

}
