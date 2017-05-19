package com.tree.www.io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.tree.www.io.Common;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(Common.FILE_NAME);
		System.err.println(path);

		System.out.println("路径数量:" + path.getNameCount());
		System.out.println("根路径：" + path.getRoot());
		System.out.println(path.toAbsolutePath());

		Path path2 = Paths.get("D:", "pys", "hello.txt");
		System.out.println(path2);
	}
}
