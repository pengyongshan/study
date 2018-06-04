package com.tree.www.pattern.mediator.mediator1;

/**
 * 中介者模式——用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式的相互引用，
 * 
 * 从而使其耦合松散，而且可以独立地改变他们的交互。
 * 
 * @author pys
 *
 * @date 2016年4月25日 上午11:24:59
 */
public class Client {

	public static void main(String[] args) {
		AbstractMediator mediator = new Mediator();

		System.out.println("---采购人员采购电脑---");
		Purchase purchase = new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		
		System.out.println("---销售人员销售电脑---");
		Sale sale = new Sale(mediator);
		sale.sellIBMcomputer(202);

		System.out.println("---库存管理人员清理库存---");
		Stock stock = new Stock(mediator);
		stock.clearStock();

	}
}
