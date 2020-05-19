package com.tree.www.leetCode;

/**
 * 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * <p>
 * Created by pysh on 2020-05-18.
 */
public class MincostTickets {
    /**
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
     * <p>
     * 火车票有三种不同的销售方式：
     * <p>
     * 一张为期一天的通行证售价为 costs[0] 美元；
     * 一张为期七天的通行证售价为 costs[1] 美元；
     * 一张为期三十天的通行证售价为 costs[2] 美元。
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     * <p>
     * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费.
     * <p>
     * ps:
     * 1 <= days.length <= 365
     * 1 <= days[i] <= 365
     * days 按顺序严格递增
     * costs.length == 3
     * 1 <= costs[i] <= 1000
     */

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1]  + 1];
        for (int day : days) {
            dp[day] = costs[0];
        }
        for (int i = 1; i < dp.length; i++) {
            //不需要买票
            if (dp[i] == 0) {
                //不需要买票花费的钱就是前一天的花费
                dp[i] = dp[i - 1];
                continue;
            }

            int n1 = dp[i - 1] + dp[i];
            int n2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            int n3 = i > 30 ? dp[i - 30] + costs[2] : costs[2];

            dp[i] = Math.min(n1, Math.min(n2, n3));
        }
        //最后一天花费多少钱
        return dp[dp.length - 1];
    }
}
