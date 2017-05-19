package com.tree.www.pattern.facade;

/**
 * 门面模式
 * 
 * @author pys
 *
 *         门面模式为整个子系统提供一种高层次的简单接口，以便减少复杂度和依赖性，这使得子系统的使用简单并且更容易管理。
 *         门面是一个类，它把客户对象所需要的子系统的功能封装到简单的接口上，客户对象不直接与子系统内部的对象打交道，
 *         而是简单地调用门面对象所提供的接口，门面对象再去调用子系统内部的具体功能。
 *         门面模式的主要目的我觉得不在于减少依赖关系(如果包括间接依赖)，而是简化用户的使用接口。
 * @date 2016年4月21日 下午6:51:59
 */
public class Client {

	public static void main(String[] args) {
		SecurityFacade facade = new SecurityFacade();
		facade.start();
		if (facade.check(true, false, false, true)) {
			System.out.println("有人闯入...");
		}

		if (!facade.check(false, false, false, false)) {
			System.out.println("20:00了 一切正常, 下班了。");
			facade.stop();
		}
	}
}
