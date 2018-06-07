package com.tree.www.pattern.observer.observer1;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Watcher2 implements Observer {

	public Watcher2() {
		// TODO Auto-generated constructor stub
	}

	public Watcher2(Observable observable) {
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("watcher2观察到对象状态发生改变：" + new Date() + "时变成" + ((Watched) o).getData());
	}

}
