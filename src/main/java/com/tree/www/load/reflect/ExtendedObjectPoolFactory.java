package com.tree.www.load.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedObjectPoolFactory {

	private Map<String, Object> objectPool = new HashMap<>();

	private Properties config = new Properties();

	public void init(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			config.load(fis);
		} catch (Exception e) {
			System.out.println("读取" + fileName + "错误");
		}
	}

	private Object createObject(String clazzName) throws Exception {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}

	public void initPool() throws Exception {
		for (String name : config.stringPropertyNames()) {
			if (!name.contains("%")) {
				objectPool.put(name, createObject(config.getProperty(name)));
			}
		}
	}

	public void initProperty() throws Exception {
		for (String name : config.stringPropertyNames()) {
			if (name.contains("%")) {
				String[] objArray = name.split("%");
				Object target = getObject(objArray[0]);
				String mtdName = "set" + objArray[1].substring(0, 1).toUpperCase() + objArray[1].substring(1);
				Class<?> targetClass = target.getClass();
				Method mtd = targetClass.getMethod(mtdName, String.class);
				mtd.invoke(target, config.getProperty(name));
			}
		}
	}

	public Object getObject(String name) {
		return objectPool.get(name);
	}

	public static void main(String[] args) throws Exception {
		ExtendedObjectPoolFactory factory = new ExtendedObjectPoolFactory();
		factory.init("extObj.txt");
		factory.initPool();
		factory.initProperty();
		System.out.println(factory.getObject("a"));
	}
}
