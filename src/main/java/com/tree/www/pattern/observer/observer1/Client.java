package com.tree.www.pattern.observer.observer1;

import java.util.Observer;

/**
 * 观察者模式--java有支持.
 *
 * @author pys
 * @date 2016年4月27日 下午3:07:57
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        Watched watched = new Watched();
        Observer observer = new Watcher1();
        Observer observer2 = new Watcher2();
        watched.addObserver(observer2);
        watched.addObserver(observer);

        watched.setData("start");
        watched.setData("bb");
        watched.deleteObserver(observer);
        watched.setData("stop");
    }
}
