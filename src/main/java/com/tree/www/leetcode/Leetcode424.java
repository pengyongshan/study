package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/2/2.
 */
public class Leetcode424 {

	/**
	 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。
	 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
	 *
	 * 注意：字符串长度 和 k 不会超过10^4。
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {
		if(s == null) return 0;
		int len = s.length();
		if(len <= k) return len;
		int left = 0, right = 0, max = 0;
		int[] counts = new int[26];
		while (right < len) {
			counts[s.charAt(right) - 'A'] ++;
			max = Math.max(max, counts[s.charAt(right) - 'A']);
			right++;
			if (right - left - max > k) {
				counts[s.charAt(left) - 'A']--;
				left++;
			}
		}
		return right - left;
	}
}
