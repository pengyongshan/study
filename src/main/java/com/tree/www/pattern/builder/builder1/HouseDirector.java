package com.tree.www.pattern.builder.builder1;

public class HouseDirector {

    private IHouseBuilder builder;

    public HouseDirector(IHouseBuilder builder) {
        this.builder = builder;
    }

    public House buildHouse() {
        builder.buildDoor();
        builder.buildFloor();
        builder.buildWall();
        builder.buildWindows();

        return builder.getHouse();
    }
}
