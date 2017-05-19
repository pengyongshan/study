package com.tree.www.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
	public static void main(String[] args) throws IOException {
		String string = "从明天起，做一个幸福的人\n" + "喂马，劈柴，周游世界\n" + "从明天起，关心粮食和蔬菜\n" + "我有一所房子，面朝大海春暖花开\n" + "从明天起，和每一个亲人通信\n"
				+ "告诉他们我的幸福\n";
		char[] c = new char[32];
		
		StringReader sr = new StringReader(string);
		int hasRead = 0;
		while ((hasRead = sr.read(c)) != -1) {
			System.out.println(new String(c, 0, hasRead));
		}
		sr.close();

		StringWriter sw = new StringWriter();
		sw.write("有一个美丽的世界，\n");
		sw.write("她在远方等我，\n");
		sw.write("那里有天真的孩子，\n");
		sw.write("还有姑娘的酒窝\n");
		System.out.println("---下面是sw字符串节点里的内容---");
		System.out.println(sw.toString());
	}
}
