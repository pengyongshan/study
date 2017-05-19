package com.tree.www.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

// 回退流， 实现只读取目标字符串前面的值
public class PushbackTest {
	public static void main(String[] args) throws IOException {
		PushbackReader pr = new PushbackReader(
				new FileReader("D:" + File.separator + "pys" + File.separator + "hello.txt"), 64);
		char[] buf = new char[32];
		String lastContent = "";
		int hasRead = 0;
		while ((hasRead = pr.read(buf)) != -1) {
			String content = new String(buf, 0, hasRead);
			int targetIndex = 0;
			if ((targetIndex = (lastContent + content).indexOf("pys")) > 0) {
				pr.unread((lastContent + content).toCharArray());
				if (targetIndex > 32) {
					buf = new char[targetIndex];
				}
				pr.read(buf, 0, targetIndex);
				System.out.println(new String(buf, 0, targetIndex));
				System.exit(0);
			} else {
				System.out.println(content);
				lastContent = content;
			}
		}
		pr.close();
	}
}
