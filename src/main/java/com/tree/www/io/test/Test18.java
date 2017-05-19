package com.tree.www.io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * ZipOutputStream 解压缩--单个文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test18 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "pys" + File.separator + "hello.zip");
		File outFile = new File("d:" + File.separator + "pys" + File.separator + "unZipFile.txt");
		ZipFile zipFile = new ZipFile(file);
		ZipEntry entry = zipFile.getEntry("hello.txt");
		InputStream in = zipFile.getInputStream(entry);
		OutputStream out = new FileOutputStream(outFile);
		int temp = 0;
		while ((temp = in.read()) != -1) {
			out.write(temp);
		}
		in.close();
		out.close();
	}
}
