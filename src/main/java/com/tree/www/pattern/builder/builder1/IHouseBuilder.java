package com.tree.www.pattern.builder.builder1;

public interface IHouseBuilder {

	void buildWall();

	void buildDoor();

	void buildFloor();

	void buildWindows();

	House getHouse();
}
