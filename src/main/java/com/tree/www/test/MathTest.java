package com.tree.www.test;

public class MathTest {

	public static void main(String[] args) {

		/** 三角运算 **/
		System.out.println(Math.toDegrees(1.57));// 弧度转角度
		System.out.println(Math.toRadians(90)); // 角度转弧度
		System.out.println(Math.acos(1.2)); // 反余弦 角度范围 0-pi
		System.out.println(Math.asin(0.8));// 反正弦 -pi/2-pi/2
		System.out.println(Math.atan(2.3)); // 反正切 -pi/2-pi/2
		System.out.println(Math.cos(1.57)); // 三角余弦
		System.out.println(Math.cosh(1.2)); // 双曲余弦
		System.out.println(Math.sin(1.57)); // 正弦
		System.out.println(Math.sinh(1.2)); // 双曲正弦
		System.out.println(Math.tan(0.8)); // 正切
		System.out.println(Math.tanh(2.1)); // 双曲正切
		System.out.println(Math.atan2(0.1, 0.2)); // 矩形坐标换成极坐标

		/** 取整 **/
		System.out.println();
		System.out.println(Math.ceil(1.1)); // 进1法
		System.out.println(Math.floor(4.9)); // 去尾法
		System.out.println(Math.round(4.5)); // 四色五入

		/** 乘方、开方 指数 **/
		System.out.println();
		System.out.println(Math.sqrt(4)); // 平方根
		System.out.println(Math.cbrt(8)); // 立方根
		System.out.println(Math.exp(2)); // e的n次幂
		System.out.println(Math.hypot(3, 4)); // 根号3的平方加4的平方
		System.out.println(Math.IEEEremainder(5, 2)); // 根据IEEE754标准求余
		System.out.println(Math.pow(3, 4)); // 3的4次方
		System.out.println(Math.log(12)); // 求自然对数
		System.out.println(Math.log1p(11)); // 等价于log(1+11)
		System.out.println(Math.log10(9)); // 求底为10的自然对数

		/** 符号相关的计算 **/
		System.out.println();
		System.out.println(Math.abs(-9.4)); // 绝对值
		System.out.println(Math.copySign(1.2, -1.1)); // 返回第一个数带第二个数的符号
		System.out.println(Math.signum(9)); // >0 1, =0 0, <0 -1

		/** 大小相关 **/
		System.out.println();
		System.out.println(Math.max(2.3, 4.1));
		System.out.println(Math.min(2.3, 4.1));
		System.out.println(Math.nextAfter(1.2, 1.5)); // 靠近第一个的最近的浮点数
		System.out.println(Math.nextUp(1.2)); // 略大于1.2的浮点数
		System.out.println(Math.random()); // 0.0<=x<1.0的随机数
	}
}
