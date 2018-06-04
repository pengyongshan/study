package com.tree.www.pattern.mediator.mediator1;

// 库存
public class Stock extends AbstractColleague {

	public Stock(AbstractMediator mediator) {
		super(mediator);
	}

	private static int COMPUTER_NUMBER = 100;

	// 增加库存
	public void increase(int number) {
		COMPUTER_NUMBER += number;
		System.out.println("库存数量为：" + COMPUTER_NUMBER);
	}

	// 库存降低
	public void decrease(int number) {
		COMPUTER_NUMBER -= number;
		System.out.println("库存数量为：" + COMPUTER_NUMBER);
	}

	// 获得库存数量
	public int getStockNumber() {
		return COMPUTER_NUMBER;
	}

	// 存货压力大，通知采购不要买，销售尽快卖
	public void clearStock() {
		System.out.println("清理存货数量为：" + COMPUTER_NUMBER);
		super.mediator.execute("stock.clear");
	}

}
