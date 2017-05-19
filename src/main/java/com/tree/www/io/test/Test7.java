package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流向文件 写入、读取 字符串
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test7 {
	public static void main(String[] args) throws IOException {
		String fileName = "D:" + File.separator + "pys" + File.separator + "hello.txt";
		File file = new File(fileName);
		OutputStream out = new FileOutputStream(file, true);
		String str = "您好"; // 换行 \n\r
		byte[] bytes = str.getBytes();
		// out.write(bytes);
		for (int i = 0; i < bytes.length; i++) {
			out.write(bytes[i]);
		}

		InputStream in = new FileInputStream(file);
		byte[] bytes2 = new byte[(int) file.length()];
		// in.read(bytes2);

		// for (int i = 0; i < bytes2.length; i++) {
		// bytes2[i] = (byte) in.read();
		// }

		int count = 0;
		int temp = 0;
		while ((temp = in.read()) != (-1)) {
			bytes2[count++] = (byte) temp;
		}

		in.close();
		System.out.println(file.length());
		System.out.println(new String(bytes2));

		// 向控制台输出
		OutputStream out1 = System.out;

		out1.write("hello".getBytes());
		out1.close();
	}
}
