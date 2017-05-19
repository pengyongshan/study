package com.tree.www.pattern.builder.builder2;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder {

	private CarModel bmw = new BMWModel();

	@Override
	public void setSequence(ArrayList sequence) {
		this.bmw.setSequence(sequence);
	}

	@Override
	public CarModel buildCarModel() {
		return this.bmw;
	}

}
