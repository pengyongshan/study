package com.tree.www.pattern.mediator.mediator1;

import java.util.Random;

public class Sale extends AbstractColleague {

	public Sale(AbstractMediator mediator) {
		super(mediator);
	}

	// 销售
	public void sellIBMcomputer(int number) {
		super.mediator.execute("sale.sell", number);
		System.out.println("销售IBM电脑" + number + "台");
	}

	// 反馈销售情况(0-100)
	public int getSaleStatus() {
		Random rand = new Random(System.currentTimeMillis());
		int saleStatus = rand.nextInt(100);
		System.out.println("IBM电脑的销售情况为：" + saleStatus);
		return saleStatus;
	}

	// 折价处理
	public void offSale() {
		super.mediator.execute("sale.offsell");
	}
}
