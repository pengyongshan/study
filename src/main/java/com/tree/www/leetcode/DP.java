package com.tree.www.leetcode;

/**
 * @author crystal
 * @since 2021/11/16
 */
public class DP {
    public static void main(String[] args) {
//        System.out.println(qw(5));
        String pagination = "Showing 211-221 of 221";
        String[] strings = pagination.split(" ");
        String num = strings[strings.length-1];
        System.out.println(pagination.indexOf(num) != pagination.lastIndexOf(num));
    }

    private static int qw(int num) {
        int[] dp = new int[num+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[num];
    }
}
