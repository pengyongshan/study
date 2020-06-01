package com.tree.www.leetcode;

/**
 * <p>
 * Created by pysh on 2020-03-26.
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit3(new int[]{1, 2, 3, 4, 5}));
    }

    // 通用解法
    public int maxProfit(int[] prices, int times) {
        if (prices.length == 0) return 0;
        if (times > prices.length / 2) {
            times = prices.length / 2;
        }
        int[][][] depth = new int[prices.length][times + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = times; j >= 1; j--) {
                if (i == 0) {
                    depth[0][j][1] = -prices[0];
                    continue;
                }
                // 今天不持有 = max(昨天不持有，昨天持有今天卖)
                depth[i][j][0] = Math.max(depth[i - 1][j][0], depth[i - 1][j][1] + prices[i]);
                // 今天持有 = max(昨天不持有今天买, 昨天持有)
                depth[i][j][1] = Math.max(depth[i - 1][j - 1][0] - prices[i], depth[i - 1][j][1]);
            }
        }
        return depth[prices.length - 1][times][0];
    }

    /**
     * 121.买卖股票的最佳时机
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     */
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] depth = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                depth[0][1] = -prices[0];
                continue;
            }
            // 今天不持有 = max(昨天不持有，昨天持有今天卖)
            depth[i][0] = Math.max(depth[i - 1][0], depth[i - 1][1] + prices[i]);
            // 今天持有 = max(昨天不持有今天买, 昨天持有)
            depth[i][1] = Math.max(-prices[i], depth[i - 1][1]);
        }
        return depth[prices.length - 1][0];
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * <p>
     * 贪心算法
     */
    public int maxProfit2(int[] prices) {
        System.out.println(maxProfit(prices, Integer.MAX_VALUE));
        if (prices.length == 0) return 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

    /**
     * 123. 买卖股票的最佳时机 III
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * <p>
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @return
     */
    public int maxProfit3(int[] prices) {
        return maxProfit(prices, 2);
    }

}
