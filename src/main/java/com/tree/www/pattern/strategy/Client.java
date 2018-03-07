package com.tree.www.pattern.strategy;

/**
 * 策略模式
 * 
 * @author pys
 *
 * @date 2016年4月28日 上午11:15:59
 */
public class Client {

	public static void main(String[] args) {
		Price price = new Price(new PrimaryMember()); // 初级会员来了
		double BOOK_PRICE = 40.70;
		System.out.println(price.quote(BOOK_PRICE));

		price = new Price(new IntermediateMember()); // 中级会员
		System.out.println(price.quote(BOOK_PRICE));

		price = new Price(new AdvancedMember()); // 高级会员
		System.out.println(price.quote(BOOK_PRICE));
	}
}
