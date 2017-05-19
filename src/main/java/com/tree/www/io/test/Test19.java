package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZipOutputStream 压缩--多个文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test19 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "pys" + File.separator + "temp");
		File zipFile = new File("d:" + File.separator + "pys" + File.separator + file.getName() + ".zip");
		InputStream in = null;
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		out.setComment(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				in = new FileInputStream(files[i]);
				out.putNextEntry(
						new ZipEntry(file.getName() + File.separator + File.separator + files[i].getName()));
				int temp = 0;
				while ((temp = in.read()) != -1) {
					out.write(temp);
				}
			}
			in.close();
		}
		out.close();
	}
}
