package com.tree.www.io.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * 序列化用于将内存中的对象（可以理解为程序的配置状态）保存到文件或数据库，待需要时恢复，
 * 
 * 或者将其在网络上传输给远程主机使用。
 * 
 * ObjectOutputStream & ObjectInputStream 序列化单个对象
 * 
 * @author pys
 *
 * @date 2016年4月14日 下午7:30:00
 */
public class Client {
	public static void main(String[] args) throws Exception {
		ser();
		dser();
	}

	private static void ser() throws Exception {
		File file = new File("D:" + File.separator + "pys" + File.separator + "serial.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(new Person("pys", 23));
		out.close();
	}

	private static void dser() throws Exception {
		File file = new File("D:" + File.separator + "pys" + File.separator + "serial.txt");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object object = in.readObject();
		System.out.println(object);
		in.close();
	}
}
