package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * 合并流 —— 主要用来将2个流合并在一起，比如将两个txt中的内容合并为另外一个txt
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test16 {
	public static void main(String[] args) throws IOException {
		File file1 = new File("d:" + File.separator + "pys" + File.separator + "hello1.txt");
		File file2 = new File("d:" + File.separator + "pys" + File.separator + "hello2.txt");
		File file3 = new File("d:" + File.separator + "pys" + File.separator + "hello3.txt");
		InputStream in1 = new FileInputStream(file1);
		InputStream in2 = new FileInputStream(file2);
		OutputStream out = new FileOutputStream(file3);
		SequenceInputStream sis = new SequenceInputStream(in1, in2);
		int temp = 0;
		while ((temp = sis.read()) != -1) {
			out.write(temp);
		}
		in1.close();
		in2.close();
		out.close();
		sis.close();
	}
}
