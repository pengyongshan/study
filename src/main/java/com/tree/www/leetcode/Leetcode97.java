package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-07-21.
 */
public class Leetcode97 {

    /**
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l3 != l1 + l2) return false;
        boolean[] dp = new boolean[l2 + 1];
        dp[0] = true;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i > 0) {
                    dp[j] &= s3.charAt(i + j - 1) == s1.charAt(i - 1);
                }
                if (j > 0) {
                    dp[j] |= dp[j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                }
            }
        }
        return dp[l2];
    }
}
