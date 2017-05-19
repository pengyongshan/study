package com.tree.www.load.reflect;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ObjectPoolFactory {

	private Map<String, Object> objectPool = new HashMap<>();

	private Object createObject(String clazzName) throws Exception {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}

	public void initPool(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		Properties props = new Properties();
		props.load(fis);
		for (String name : props.stringPropertyNames()) {
			objectPool.put(name, createObject(props.getProperty(name)));
		}
	}

	public Object getObject(String name) {
		return objectPool.get(name);
	}

	public static void main(String[] args) throws Exception {
		ObjectPoolFactory opf = new ObjectPoolFactory();
		opf.initPool("obj.txt");
		System.out.println(opf.getObject("a"));
		System.out.println(opf.getObject("b"));
	}
}
