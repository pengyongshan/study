package com.tree.www.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

/** 只能装枚举值,位向量存储 ，内存使用少 效率快 **/
public class EnumSetTest {
	public static void main(String[] args) {
		EnumSet es1 = EnumSet.allOf(Season.class); // 包含Season所有枚举值得EnumSet对象,按定义顺序排序
		System.out.println(es1);
		EnumSet es2 = EnumSet.noneOf(Season.class); // 指定元素为Season的空集合
		System.out.println(es2);
		es2.add(Season.FALL);
		es2.add(Season.SPRING);
		System.out.println(es2);
		EnumSet es3 = EnumSet.complementOf(es2); // es2 + es3 = Season.values();
		System.out.println(es3);
		EnumSet es4 = EnumSet.of(Season.WINTER, Season.SUMMER); // WINTER,SUMMER
		System.out.println(es4);
		EnumSet es5 = EnumSet.range(Season.SUMMER, Season.WINTER); // SUMMER到WINTER
		System.out.println(es5);
		EnumSet es6 = EnumSet.copyOf(es5); // 复制
		System.out.println(es6);

		Collection cc = new ArrayList();
		cc.add(Season.SPRING);
		cc.add(Season.FALL);
		EnumSet es7 = EnumSet.copyOf(cc); // 从集合复制创建EnumSet对象
		System.out.println(es7);
		// cc.add("aa");
		// es7 = EnumSet.copyOf(cc); // 只能装枚举
	}
}

enum Season {
	SPRING, SUMMER, FALL, WINTER;
}
