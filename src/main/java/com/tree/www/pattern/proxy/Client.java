package com.tree.www.pattern.proxy;

/**
 * 代理模式——为其他对象提供一种代理以控制对这个对象的访问
 * 
 * 代理人和被代理人继承同一个接口。
 * 
 * @author pys
 *
 * @date 2016年4月28日 上午10:08:56
 */
public class Client {

	public static void main(String[] args) {
		// 客人来了 请出代理
		KindWomen wanpo = new WanPo(); // 默认代理潘金莲
		wanpo.happyWithMan();
		wanpo.makeEyesWithMan();

		wanpo = new WanPo(new LiJinLian()); // 代理李金莲
		wanpo.makeEyesWithMan();
		wanpo.happyWithMan();
	}

}
