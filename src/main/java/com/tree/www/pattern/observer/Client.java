package com.tree.www.pattern.observer;

import java.util.Observer;

/**
 * 观察者模式--java有支持. 观察者处理需要长时间时，异步处理。
 * 
 * @author pys
 *
 * @date 2016年4月27日 下午3:07:57
 */
public class Client {

	public static void main(String[] args) throws InterruptedException {
		Watched watched = new Watched();
		Watched watched1 = new Watched();
		Watched watched2 = new Watched();
		Observer observer = new Watcher1();
		Observer observer2 = new Watcher2();
		watched.addObserver(observer);
		watched.addObserver(observer2);
		watched1.addObserver(observer);
		watched1.addObserver(observer2);
		watched2.addObserver(observer);
		watched2.addObserver(observer2);

		watched.setData("start");
		new Thread(watched).start();
		watched1.setData("bb");
		new Thread(watched1).start();
		watched2.setData("stop");
		new Thread(watched2).start();

		System.out.println("balabalabala");
	}
}
