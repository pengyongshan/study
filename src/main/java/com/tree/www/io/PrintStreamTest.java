package com.tree.www.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// 输出一般用PrintStream
public class PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException {

		PrintStream ps = new PrintStream(
				new FileOutputStream(new File("D:" + File.separator + "pys" + File.separator + "hello.txt")));
		ps.println("xxxx");
		ps.println("yyyy");
		ps.close();
	}
}
