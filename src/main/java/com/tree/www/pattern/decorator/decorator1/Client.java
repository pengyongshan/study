package com.tree.www.pattern.decorator.decorator1;

/**
 * 装饰模式
 * 
 * 在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 * 
 * 1. 需要扩展一个类的功能，或给一个类添加附加职责。
 * 
 * 2. 需要动态的给一个对象添加功能，这些功能可以再动态的撤销。
 * 
 * 3. 需要增加由一些基本功能的排列组合而产生的非常大量的功能，从而使继承关系变的不现实。
 * 
 * 4. 当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。
 * 另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
 * 
 * @author pys
 *
 * @date 2016年4月21日 下午2:57:56
 * 
 *       类似 I/O 层层包装
 */
public class Client {

	public static void main(String[] args) {
		Decorator decorator = new DecoratorImpl_3(new DecoratorImpl_2(new DecoratorImpl_1(new Person())));
		decorator.wearClothes();
		System.out.println();
		decorator.walkToWhere();
	}
}
