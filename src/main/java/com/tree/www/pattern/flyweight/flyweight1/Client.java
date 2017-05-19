package com.tree.www.pattern.flyweight.flyweight1;

/**
 * 享元模式
 * 
 * @author pys
 *
 * @date 2016年4月22日 上午10:05:15
 */
public class Client {
	public static void main(String[] args) {

		System.out.println(SignInfoFactory.getPoolSize());
		SignInfo signInfo1 = SignInfoFactory.getSignInfo("科目1上海");
		SignInfo signInfo2 = SignInfoFactory.getSignInfo("科目3上海");
		SignInfo signInfo3 = SignInfoFactory.getSignInfo("科目4上海");
		SignInfo signInfo4 = SignInfoFactory.getSignInfo("科目5上海");
		SignInfo signInfo5 = SignInfoFactory.getSignInfo("科目6上海");
		SignInfo signInfo6 = SignInfoFactory.getSignInfo("科目7上海");
		SignInfo signInfo7 = SignInfoFactory.getSignInfo("科目1上海");
		SignInfo signInfo8 = SignInfoFactory.getSignInfo("科目3上海");
		SignInfo signInfo9 = SignInfoFactory.getSignInfo("科目1上海");
		SignInfo signInfo10 = SignInfoFactory.getSignInfo("科目3上海");
		SignInfo signInfo11 = SignInfoFactory.getSignInfo("科目1上海");
		SignInfo signInfo12 = SignInfoFactory.getSignInfo("科目3上海");

		System.out.println(SignInfoFactory.getPoolSize());

	}
}
