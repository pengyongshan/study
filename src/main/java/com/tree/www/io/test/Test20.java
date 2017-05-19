package com.tree.www.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * ZipInputStream 解压--多个文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test20 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "pys" + File.separator + "temp.zip");
		File outFile = null;
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
		ZipEntry entry = null;
		InputStream in = null;
		OutputStream out = null;
		while ((entry = zipInput.getNextEntry()) != null) {
			System.out.println(entry.getName());
			outFile = new File("d:" + File.separator + "pys" + File.separator + entry.getName());
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			in = zipFile.getInputStream(entry);
			out = new FileOutputStream(outFile);
			int temp = 0;
			while ((temp = in.read()) != -1) {
				out.write(temp);
			}
			in.close();
			out.close();
		}

	}
}
