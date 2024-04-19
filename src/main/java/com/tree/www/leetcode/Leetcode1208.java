package com.tree.www.leetcode;

/**
 * 尽可能使字符串相等
 * <p>
 * Created by pysh on 2021/2/5.
 */
public class Leetcode1208 {
	/**
	 * 给你两个长度相同的字符串，s 和 t。
	 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），
	 * 也就是两个字符的 ASCII 码值的差的绝对值。
	 * <p>
	 * 用于变更字符串的最大预算是 maxCost。
	 * 在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
	 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
	 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
	 * <p>
	 * ps:
	 * 1 <= s.length, t.length <= 10^5
	 * 0 <= maxCost <= 10^6
	 * s 和 t 都只含小写英文字母。
	 *
	 * @param s
	 * @param t
	 * @param maxCost
	 * @return
	 */
	public int equalSubstring(String s, String t, int maxCost) {
		int left = 0, right = 0, len = 0, length = s.length();
		int[] diff = new int[length];
		for (int i = 0; i < length; i++) {
			diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
		}
		while (right < length) {
			maxCost -= diff[right];
			if (maxCost >= 0) {
				len = Math.max(right - left + 1, len);
			} else {
				maxCost += diff[left];
				left++;
			}
			right++;
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(new Leetcode1208().equalSubstring("abcd", "bcdf", 0));
	}
}
