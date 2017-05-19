package com.tree.www.io.nio;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.tree.www.io.Common;

public class FilesTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(Common.FILE_NAME);
		Files.copy(path, new FileOutputStream("D:\\pys\\ss.txt")); // 复制
		System.out.println(Files.isHidden(path));
		List<String> list = Files.readAllLines(path, Charset.forName("GBK"));
		System.out.println(list);
		System.out.println(Files.size(path));
		
		List<String> poem = new ArrayList<>();
		poem.add("水清则无鱼");
		poem.add("xxxxx");
		Files.write(Paths.get("D:\\pys\\ss11.txt"), poem, Charset.forName("GBK"));
	}
}
