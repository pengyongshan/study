package com.tree.www.pattern.strategy;

// 初级会员
public class PrimaryMember implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		return bookPrice; // 不打折
	}

}
