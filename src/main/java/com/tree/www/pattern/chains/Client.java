package com.tree.www.pattern.chains;

import java.util.ArrayList;
import java.util.Random;

/**
 * 责任链模式
 * 
 * @author pys
 *
 * @date 2016年4月20日 下午5:32:20
 */
public class Client {

	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<IWomen> womens = new ArrayList<IWomen>();
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			temp = random.nextInt(4);
			System.out.println(temp);
			womens.add(new Women(temp, "我要出去逛街"));
		}

		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		father.setNextHandler(husband);
		husband.setNextHandler(son);

		for (IWomen women : womens) {
			father.HandleMessage(women);
			System.out.println();
		}
	}
}
