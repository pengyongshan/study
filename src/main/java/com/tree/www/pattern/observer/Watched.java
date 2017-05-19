package com.tree.www.pattern.observer;

import java.util.Observable;

// 被观察者
public class Watched extends Observable implements Runnable {

	private String data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}
	}

	@Override
	public void run() {
		notifyObservers();
	}

}
