package com.tree.www.pattern.builder.builder1;

/**
 * 控制建造内容
 * 
 * @author pys
 *
 * @date 2016年4月20日 下午4:06:02
 */
public class Client {
	public static void main(String[] args) {
		IHouseBuilder builder = new BritishHouseBuilder();
		//IHouseBuilder builder = new ChinaHouseBuilder();
		HouseDirector director = new HouseDirector(builder);
		House house = director.buildHouse();
		System.out.println(house);
	}
}
