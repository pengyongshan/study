package com.tree.www.io.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import com.tree.www.io.Common;

public class AttributeViewTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(Common.FILE_NAME);
		// 基本信息
		BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		BasicFileAttributes basicAttribs = basicView.readAttributes();
		System.out.println("创建时间：" + basicAttribs.creationTime());
		System.out.println("访问时间：" + basicAttribs.lastAccessTime());
		System.out.println("最后修改时间：" + basicAttribs.lastModifiedTime());
		System.out.println("文件大小：" + basicAttribs.size());

		// 属主信息
		FileOwnerAttributeView owner = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
		System.out.println(owner.getOwner()); // 文件用户
		// guest对应得用户
		UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");

		// 自定义属性
		UserDefinedFileAttributeView userView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);

		List<String> list = userView.list();
		userView.write("发者", Charset.defaultCharset().encode("xxx"));
		for (String name : list) {
			ByteBuffer bbuff = ByteBuffer.allocate(userView.size(name));
			userView.read(name, bbuff);
			bbuff.flip();
			String value = Charset.defaultCharset().decode(bbuff).toString();
			System.out.println(name + "--->" + value);
		}

		// dos属性
		DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
		dosView.setHidden(true);
		dosView.setReadOnly(false);
	}
}
