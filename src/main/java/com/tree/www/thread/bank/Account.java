package com.tree.www.thread.bank;

public class Account {

	private String accountNo;

	private double balance;

	private boolean flag;

	public Account() {

	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public synchronized void draw(double drawAmount){
		try {
			if(!flag){
				wait();
			} else{
				System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
				balance -= drawAmount;
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + " 存钱：" + depositAmount);
				balance += depositAmount;
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Account account = new Account("123456", 0);
		new Thread(new DrawThread(account, 500), "取钱者甲").start();
		new Thread(new DepositThread(account, 500), "存钱者乙").start();
		new Thread(new DrawThread(account, 500), "取钱者丙").start();
		Thread.sleep(1000);
		System.out.println(account.balance);
	}
}
