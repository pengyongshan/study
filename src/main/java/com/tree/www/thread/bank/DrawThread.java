package com.tree.www.thread.bank;

public class DrawThread implements Runnable {

	private Account account;

	private double drawAmount;

	public DrawThread(Account account, double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.draw(drawAmount);
		}
	}

}
