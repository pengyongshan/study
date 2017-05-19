package com.tree.www.pattern.builder.builder1;

public class ChinaHouseBuilder implements IHouseBuilder {

	private House house = new ChinaStyleHouse();

	@Override
	public void buildWall() {
		house.setWall("中式墙壁");
	}

	@Override
	public void buildDoor() {
		house.setDoor("中式门");
	}

	@Override
	public void buildFloor() {
		house.setFloor("中式地板");
	}

	@Override
	public void buildWindows() {
		house.setWindows("中式窗户");
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
