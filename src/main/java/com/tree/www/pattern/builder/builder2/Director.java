package com.tree.www.pattern.builder.builder2;

import java.util.ArrayList;

public class Director {

	private ArrayList<String> sequence = new ArrayList<String>();

	private CarBuilder benzBuilder = new BenzBuilder();

	private CarBuilder bmwBuilder = new BMWBuilder();

	public BenzModel getABenzModel() {

		this.sequence.clear();
		this.sequence.add("start");
		this.sequence.add("stop");
		this.benzBuilder.setSequence(sequence);
		return (BenzModel) this.benzBuilder.buildCarModel();
	}

	public BenzModel getBBenzModel() {

		this.sequence.clear();
		this.sequence.add("engineBoom");
		this.sequence.add("start");
		this.sequence.add("stop");
		this.benzBuilder.setSequence(sequence);
		return (BenzModel) this.benzBuilder.buildCarModel();
	}

	public BMWModel getABMWModel() {

		this.sequence.clear();
		this.sequence.add("alarm");
		this.sequence.add("engineBoom");
		this.sequence.add("start");
		this.sequence.add("stop");
		this.bmwBuilder.setSequence(sequence);
		return (BMWModel) this.bmwBuilder.buildCarModel();
	}

	public BMWModel getBBMWzModel() {

		this.sequence.clear();
		this.sequence.add("start");
		this.sequence.add("alarm");
		this.sequence.add("stop");
		this.bmwBuilder.setSequence(sequence);
		return (BMWModel) this.bmwBuilder.buildCarModel();
	}

}
