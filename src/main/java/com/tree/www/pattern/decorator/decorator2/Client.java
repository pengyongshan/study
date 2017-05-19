package com.tree.www.pattern.decorator.decorator2;

public class Client {

	public static void main(String[] args) {
		// 普通鸡腿堡
		Humburger humburger = new ChickenBurger();
		System.out.println(humburger);
		
		// 加生菜
		Humburger lettuce = new Lettuce(humburger);
		System.out.println(lettuce);
		
		// 加辣椒
		Humburger chilli = new Chilli(humburger);
		System.out.println(chilli);
		
		// 加生菜 加辣椒
		Humburger chilett = new Chilli(lettuce);
		System.out.println(chilett);
		

		// 加辣椒 加生菜
		chilett = new Lettuce(chilli);
		System.out.println(chilett);
	
		// 加生菜 加生菜
		chilett = new Lettuce(lettuce);
		System.out.println(chilett);
		
	}
}
