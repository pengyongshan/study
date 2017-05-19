package com.tree.www.pattern.flyweight.flyweight2;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式---采用一个共享来避免大量拥有相同内容对象的开销。
 * 
 * @author pys
 *
 * @date 2016年4月22日 下午2:32:54
 */
public class Client {

	public static void main(String[] args) {
		List<String> compositeStates = new ArrayList<String>();
		compositeStates.add("aa");
		compositeStates.add("bb");
		compositeStates.add("cc");
		compositeStates.add("aa");
		compositeStates.add("cc");
		
		FlyweightFactory factory = FlyweightFactory.getInstance();
		Flyweight compositeFly1 = factory.getFly(compositeStates);
		Flyweight compositeFly2 = factory.getFly(compositeStates);
		compositeFly1.operation("Composite1 Call");
		System.out.println();
		compositeFly2.operation("Composite2 Call");
		System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));

		Flyweight fly1 = factory.getFly("aa");
		Flyweight fly2 = factory.getFly("aa");
		System.out.println(fly1 == fly2);
	}
}
