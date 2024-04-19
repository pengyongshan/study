package com.tree.www.leetcode;

/**
 * 具有给定数值的最小字符串
 * <p>
 * Created by pysh on 2021/2/7.
 */
public class Leetcode1663 {
	/**
	 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
	 * <p>
	 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
	 * <p>
	 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
	 * <p>
	 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
	 * <p>
	 * x 是 y 的一个前缀；
	 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
	 *
	 * @param n
	 * @param k
	 * @return 1 <= n <= 105
	 * n <= k <= 26 * n
	 */
	public String getSmallestString(int n, int k) {
		int balance = k - n;

		int zc = balance / 25;
		int oc = balance % 25 != 0 ? 1 : 0;
		int ac = n - zc - oc;

		StringBuilder sb = new StringBuilder(n);
		while(ac-- > 0) sb.append('a');
		if(oc == 1) {
			sb.append((char) (balance % 25 + 'a'));
		}
		while(zc -- > 0) sb.append('z');
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Leetcode1663().getSmallestString(5, 124));
	}
}
