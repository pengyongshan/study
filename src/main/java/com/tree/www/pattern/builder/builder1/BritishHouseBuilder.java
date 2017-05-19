package com.tree.www.pattern.builder.builder1;

public class BritishHouseBuilder implements IHouseBuilder {

	private House house = new ChinaStyleHouse();

	@Override
	public void buildWall() {
		house.setWall("英式墙壁");
	}

	@Override
	public void buildDoor() {
		house.setDoor("英式门");
	}

	@Override
	public void buildFloor() {
		house.setFloor("英式地板");
	}

	@Override
	public void buildWindows() {
		house.setWindows("英式窗户");
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
