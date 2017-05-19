package com.tree.www.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class CopyTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// 字节流复制
		OutputStream fos = new FileOutputStream(
				new File("D:" + File.separator + "pys" + File.separator + "hello-1.txt"));
		InputStream fis = new FileInputStream(new File(Common.FILE_NAME));
	
		byte[] b = new byte[1024];
		
		while (fis.read(b) != -1) {
			fos.write(b);
		}
		fis.close();
		fos.close();

		// 字符流复制
		Writer fw = new FileWriter(new File("D:" + File.separator + "pys" + File.separator + "hello-2.txt"));
		Reader fr = new FileReader(new File("D:" + File.separator + "pys" + File.separator + "hello.txt"));

		char[] c = new char[32];
		while (fr.read(c) != -1) {
			System.out.println(c);
			fw.write(c);
		}
		fr.close();
		fw.close();
	}
}
