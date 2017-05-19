package com.tree.www.pattern.template;

/**
 * 模板方法模式——定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 
 * HttpServlet担任抽象模板角色
 * 
 * 模板方法：由service()方法担任。
 * 基本方法：由doPost()、doGet()等方法担任。
 * 
 * @author pys
 *
 * @date 2016年4月28日 下午2:37:36
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("============= 准备茶 =============");
		Beverage tea = new Tea();
		tea.prepareBeverage();

		System.out.println("============= 准备蜂蜜水 =============");
		Beverage honey = new Honey();
		honey.prepareBeverage();
	}
}
