package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-06-09.
 */
public class LeetcodeInterview46 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，
     * ……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        int len = nums.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int pre = Integer.valueOf(nums.substring(i - 1, i + 1));
            dp[i] = dp[i - 1];
            if (pre <= 25) dp[i] += (i > 2 ? dp[i - 2] : 1);
            while(nums.charAt(i) == '0' && ++i < len) {
                dp[i] = dp[i-1];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetcodeInterview46().translateNum(26));
    }
}
