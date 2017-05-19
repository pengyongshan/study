package com.tree.www.pattern.mediator;

public class Mediator extends AbstractMediator {

	@Override
	public void execute(String str, Object... objects) {
		if (str.equals("purchase.buy")) { // 采购
			this.buyComputer((Integer) objects[0]);
		} else if (str.equals("sale.sell")) { // 销售
			this.sellComputer((Integer) objects[0]);
		} else if (str.equals("sale.offsell")) { // 折价销售
			this.offsell();
		} else if (str.equals("stock.clear")) { // 清仓
			this.clearStock();
		}
	}

	// 清仓
	private void clearStock() {
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}

	// 折价处理
	private void offsell() {
		System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台");
	}

	// 销售
	private void sellComputer(Integer number) {
		if (super.stock.getStockNumber() < number) { // 库存不足
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}

	// 采购
	private void buyComputer(Integer number) {
		int saleStatus = super.sale.getSaleStatus();
		if (saleStatus > 80) { // 销售情况好
			System.out.println("采购电脑：" + number + "台");
			super.stock.increase(number);
		} else { // 销售不好 折半采购
			int buyNumber = number / 2;
			System.out.println("采购电脑：" + buyNumber + "台");
			super.stock.increase(buyNumber);
		}
	}

}
