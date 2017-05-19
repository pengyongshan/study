package com.tree.www.load.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

public class GenericTest {

	private Map<String, Integer> score;

	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz = GenericTest.class;
		Field f = clazz.getDeclaredField("score");
		Class<?> a = f.getType();
		System.out.println("score的类型是:" + a);
		Type gType = f.getGenericType();
		if (gType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) gType;
			Type rType = pType.getRawType();
			System.out.println("原始类型是:" + rType);
			Type[] tArgs = pType.getActualTypeArguments();
			System.out.println(Arrays.toString(tArgs));
		} else {
			System.out.println("获取泛型类型出错");
		}
	}
}
