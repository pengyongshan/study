package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-07-10.
 */
public class Leetcode309 {

    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int len = prices.length;
        // 0 持有, 1 不持有不冷冻，2 不持有冷冻
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            //今天持有 =  昨天已持有 || 今天买
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //今天不持有不冷冻 =  昨天不冷冻 || 昨天冷冻
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            //今天不持有冷冻 = 昨天持有今天卖
            dp[i][2] = dp[i-1][0] + prices[i];
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
