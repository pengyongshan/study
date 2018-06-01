package com.tree.www.pattern.composite.composite1;

/**
 * 组合模式(透明)
 * 
 * 当发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，
 * 
 * 统一地使用组合结构中的所有对象时，就应该考虑组合模式了。
 * 
 * @author pys
 *
 * @date 2016年4月21日 下午2:18:32
 */
public class Client {

	public static void main(String[] args) {
		Component root = new Composite("root");
		root.add(new Leaf("Leaf A"));
		root.add(new Leaf("Leaf B"));

		Component compX = new Composite("Composite X");
		root.add(compX);
		compX.add(new Leaf("Leaf XA"));
		compX.add(new Leaf("Leaf XB"));

		Component compXY = new Composite("Composite XY");
		compX.add(compXY);
		compXY.add(new Leaf("Leaf XYA"));
		compXY.add(new Leaf("Leaf XYB"));
		Component compXYZ = new Composite("Composite XYZ");
		compXYZ.add(new Leaf("Leaf XYZA"));
		compXY.add(compXYZ);
		compXY.remove(compXYZ);

		compX.display(0);
	}
}
