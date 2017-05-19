package com.tree.www.io.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.tree.www.io.Common;

/**
 * 利用RandomAccessFile写入文件
 * 
 * @author pys
 *
 * @date 2016年4月14日 上午10:29:05
 */
public class Test6 {
	public static void main(String[] args) throws IOException {
		File file = new File(Common.FILE_NAME);
		RandomAccessFile demo = new RandomAccessFile(file, "rw");
		// demo.write(1);
		// demo.writeBytes("aqww");
		// demo.writeInt(12);
		// demo.writeBoolean(false);
		int count = 0;
		int hasRead = 0;
		byte[] b = new byte[1024];
		while ((hasRead = demo.read(b)) != -1) {
			System.out.println(new String(b, 0, hasRead));
		}
		demo.read();
		demo.close();
	}
}
