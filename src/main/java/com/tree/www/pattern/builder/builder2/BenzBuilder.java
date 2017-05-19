package com.tree.www.pattern.builder.builder2;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder {

	private CarModel benz = new BenzModel();

	@Override
	public void setSequence(ArrayList sequence) {
		this.benz.setSequence(sequence);
	}

	@Override
	public CarModel buildCarModel() {
		return this.benz;
	}

}
