package com.tree.www.pattern.singleton;

/**
 * 静态内部类——这种方式是Singleton类被装载了，instance不一定被初始化。
 * 
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 
 * 才会显示装载SingletonHolder类， 从而实例化instance。
 * 
 * @author pys
 *
 * @date 2016年4月28日 上午10:46:46
 */
public class Singleton2 {

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		return SingletonHolder.INSTANCE;
	}
	private static class SingletonHolder {
		private static Singleton2 INSTANCE = new Singleton2();
	}

}
