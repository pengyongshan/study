package com.tree.www.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * Created by pysh on 2020-05-26.
 */
public class Leetcode29 {

    /**
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
     *
     * @param a
     * @param b
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        long result = dividend < 0 ^ divisor < 0 ? -1 : 1, rest = 0;
        int index = 1;
        long a = dividend, b = divisor;
        long[] dp = new long[34];
        long[] dpRest = new long[34];
        while (Math.abs(a) >= Math.abs(b)) {
            dp[index] = b;
            dpRest[index++] = result;
            b += b;
            result += result;
        }
        while (index > 0) {
            if (Math.abs(a) >= Math.abs(dp[--index])) {
                if (result < 0) {
                    a += dp[index];
                } else {
                    a -= dp[index];
                }
                rest += dpRest[index];
            }
        }
        return (int) rest;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode29().divide(Integer.MIN_VALUE, 3));
    }
}
