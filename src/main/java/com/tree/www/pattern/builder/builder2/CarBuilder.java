package com.tree.www.pattern.builder.builder2;

import java.util.ArrayList;

public abstract class CarBuilder {
	
	public abstract void setSequence(ArrayList sequence);
	
	public abstract CarModel buildCarModel();
}
