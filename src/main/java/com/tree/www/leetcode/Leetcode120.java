package com.tree.www.leetcode;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * Created by pysh on 2020-07-14.
 */
public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int ans = dp[len - 1][0];
        for (int i = 1; i < len; i++) {
            ans = Math.min(ans, dp[len - 1][i]);
        }
        return ans;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[] dp = triangle.get(n - 1).toArray(new Integer[n]);
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
