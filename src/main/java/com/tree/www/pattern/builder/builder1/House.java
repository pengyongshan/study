package com.tree.www.pattern.builder.builder1;

public abstract class House {

	private String door;

	private String floor;

	private String wall;

	private String windows;

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getWindows() {
		return windows;
	}

	public void setWindows(String windows) {
		this.windows = windows;
	}

	@Override
	public String toString() {
		return "House [door=" + door + ", floor=" + floor + ", wall=" + wall + ", windows=" + windows + "]";
	}
}
