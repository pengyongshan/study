package com.tree.www.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal(0.1); // 会发生精度丢失 一般采用下面2种方法构建BigDecimal对象
		BigDecimal bd2 = new BigDecimal("0.1");
		BigDecimal bd3 = BigDecimal.valueOf(0.05);
		System.out.println(bd.add(bd2));
		System.out.println(bd2.add(bd3));
		System.out.println(bd3.add(bd));

		System.out.println();
		System.out.println(DoubleUtil.add(0.2, 0.3333));
		System.out.println(DoubleUtil.sub(0.54, 0.1111));
		System.out.println(DoubleUtil.mul(0.98, 0.11));
		System.out.println(DoubleUtil.div(5, 2.3));
		System.out.println(DoubleUtil.div(5, 2.3, 2));
	}

}

class DoubleUtil {
	/** 实际运用封装 **/
	private static final int DEF_DIV_SCALE = 2; // 默认精确到小数点后2位

	private DoubleUtil() {
	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);

		return b1.add(b2).doubleValue();
	}

	public static double sub(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}

	public static double mul(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.multiply(b2).doubleValue();
	}

	public static double div(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static double div(double v1, double v2, int scale) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		if (scale < 0) {
			throw new IllegalArgumentException("scale must be a positive integer or zero.");
		}
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
