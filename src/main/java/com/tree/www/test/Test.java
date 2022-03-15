package com.tree.www.test;

import org.springframework.util.AntPathMatcher;

/**
 * Created by pysh on 2017/6/21.
 */
public class Test {

	public static void main(String[] args) {
		//double x1 = 1 - 18900.0 / 19550;
		//double x2 = 1 - 18600.0 / 19100;
		//double x3 = 1 - 17200.0 / 18900;
		//double x4 = 1 - 17170.0 / 18050;
		//double x5 = 1 - 17700.0 / 18070;
		//System.out.println(x1);
		//System.out.println(x2);
		//System.out.println(x3);
		//System.out.println(x4);
		//System.out.println(x5);
		AntPathMatcher matcher = new AntPathMatcher();
		String path = "/risk-backstage/v1/cloudapi/bank";
		String path2 = "/risk-backstage/cloudapi/bank";
		System.out.println(matcher.match("/*/cloudapi/**", path));
		System.out.println(matcher.match("/*/cloudapi/**", path2));
		System.out.println(matcher.match("/**/cloudapi/**", path));
		System.out.println(matcher.match("/**/cloudapi/**", path2));
	}

	private static String longStr(int len) {
		String a = "";
		for (int i = 0; i < len; i++) {
			a += "a";
		}
		return a;
	}

}