package com.tree.www.pattern.builder.builder2;

import java.util.ArrayList;

public abstract class CarModel {

	private ArrayList<String> sequence = new ArrayList<String>();

	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	final public void run() {
		for (String string : sequence) {
			if (string.equals("start")) {
				this.start();
			}
			if (string.equals("stop")) {
				this.stop();
			}
			if (string.equals("alarm")) {
				this.alarm();
			}
			if (string.equals("engineBoom")) {
				this.engineBoom();
			}
		}

		System.out.println();
	}

	final public void setSequence(ArrayList<String> sequence) {
		this.sequence = sequence;
	}
}
