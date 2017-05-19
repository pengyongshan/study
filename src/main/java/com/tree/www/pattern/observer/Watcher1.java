package com.tree.www.pattern.observer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Watcher1 implements Observer {

	public Watcher1() {
		// TODO Auto-generated constructor stub
	}

	public Watcher1(Observable observable) {
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("watcher1观察到对象状态发生改变：" + new Date() + "时变成" + ((Watched) o).getData());
	}
}
