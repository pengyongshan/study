package com.tree.www.pattern.strategy;

// 中级会员
public class IntermediateMember implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		return bookPrice * 0.9; // 中级会员打9折
	}

}
