package com.tree.www.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

		File file = new File("."); // 当前路径
		System.out.println(file.getName());
		System.out.println(file.getParent());

		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());

		File tmpFile = File.createTempFile("aaa", ".txt", file); // 当前路径创建文件
		tmpFile.deleteOnExit(); // 退出时删除
		File newFile = new File(System.currentTimeMillis() + "");

		System.out.println("newFile对象是否存在：" + newFile.exists());
		newFile.createNewFile();
		newFile.mkdir();

		String[] fileList = file.list();
		System.out.println("==当前路径下的所有文件和路径==");
		for (String string : fileList) {
			System.out.println(string);
		}

		File[] root = File.listRoots();
		System.out.println("==系统所有根路径如下==");
		for (File file2 : root) {
			System.out.println(file2);
		}
	}
}
