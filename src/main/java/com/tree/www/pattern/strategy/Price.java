package com.tree.www.pattern.strategy;

// 环境角色
public class Price {

	private MemberStrategy memberStrategy;

	public Price(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}

	public double quote(double bookPrice) {
		return memberStrategy.calcPrice(bookPrice);
	}
}
