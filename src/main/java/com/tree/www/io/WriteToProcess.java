package com.tree.www.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {

	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		PrintStream ps = new PrintStream(p.getOutputStream());
		ps.println("xxxx");
		ps.println(new WriteToProcess());
		System.out.println("ok");
		ps.close();
	}
}

class ReadStandard {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new FileOutputStream(new File("D:/pys/hello.txt")));
		sc.useDelimiter("\n");
		while (sc.hasNext()) {
			ps.println("键盘输入的内容是：" + sc.next());
		}
		ps.close();
	}
}
