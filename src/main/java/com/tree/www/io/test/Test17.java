package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZipOutputStream 压缩--单个文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test17 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "pys" + File.separator + "hello.txt");
		File zipFile = new File("d:" + File.separator + "pys" + File.separator + "hello.zip");
		InputStream in = new FileInputStream(file);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		int temp = 0;
		out.putNextEntry(new ZipEntry(file.getName()));
		out.setComment("hello");
		while ((temp = in.read()) != -1) {
			out.write(temp);
		}
		in.close();
		out.close();
	}
}
