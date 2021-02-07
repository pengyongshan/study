package com.tree.www.leetcode;

/**
 * 避免重复字母的最小删除成本
 *
 * Created by pysh on 2021/2/7.
 */
public class Leetcode1578 {
	/**
	 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
	 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
	 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
	 *
	 * @param s
	 * @param cost
	 * @return
	 *
	 * ps:
	 * s.length == cost.length
	 * 1 <= s.length, cost.length <= 10^5
	 * 1 <= cost[i] <= 10^4
	 * s 中只含有小写英文字母
	 *
	 */
	public int minCost(String s, int[] cost) {
		int i = 0, len = s.length();
		int ret = 0;
		while (i < len) {
			char ch = s.charAt(i);
			int maxValue = 0;
			int sum = 0;

			while (i < len && s.charAt(i) == ch) {
				maxValue = Math.max(maxValue, cost[i]);
				sum += cost[i];
				i++;
			}
			ret += (sum - maxValue);
		}
		return ret;
	}
}
