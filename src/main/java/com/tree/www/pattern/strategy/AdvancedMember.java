package com.tree.www.pattern.strategy;

// 高级会员
public class AdvancedMember implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		return bookPrice * 0.8; // 高级会员打八折
	}
}
