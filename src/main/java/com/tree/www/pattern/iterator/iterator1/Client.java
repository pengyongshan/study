package com.tree.www.pattern.iterator.iterator1;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式-- 提供一种方法访问一个容器对象中各个元素，而又不暴露该对象的内部细节。
 * 
 * 很少自己写 一般高级语言都封装好了
 * 
 * @author pys
 *
 * @date 2016年4月25日 上午10:04:32
 */
public class Client {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add("b");
		list.add("c");
		Aggregate aggregate = new ConcreteAggregate(list);
		Iterator iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next().toString();
			System.out.println(str);
		}
	}
}

