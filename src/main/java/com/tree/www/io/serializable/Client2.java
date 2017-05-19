package com.tree.www.io.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * ObjectOutputStream & ObjectInputStream 序列化一组对象
 * 
 * @author pys
 *
 * @date 2016年4月14日 下午7:30:00
 */
public class Client2 {
	public static void main(String[] args) throws Exception {
		ser(new Person("ss", 11), new Person("ss2", 22), new Person("ss3", 33));
		Object[] obj = dser();
		for (Object object : obj) {
			System.out.println(object);
		}
	}

	private static void ser(Object... obj) throws Exception {
		File file = new File("D:" + File.separator + "pys" + File.separator + "serial.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(obj);
		out.close();
	}

	private static Object[] dser() throws Exception {
		File file = new File("D:" + File.separator + "pys" + File.separator + "serial.txt");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object[] object = (Object[]) in.readObject();
		in.close();
		return object;
	}
}
