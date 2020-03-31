package com.tree.www.leetCode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * Created by pysh on 2020-03-27.
 */
public class CoinChange {

    int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = {294,128,316,466,108,463,321,490};
        //int[] coins = {1, 3};
        System.out.println(new CoinChange().coinChange(coins, 7130));
    }

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public  int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        min(coins, amount, coins.length - 1, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private  void min(int[] coins, int amount, int index, int count) {
        if (index < 0) {
            return;
        }

        int num = amount / coins[index];
        for (int i = num; i >=0; i--) {
            if(amount - i * coins[index] == 0) {
                minCount = Math.min(minCount, count);
                break;
            }
            if(count + i + 1 > minCount) break;
            min(coins, amount - i * coins[index], index - 1, count + i);
        }
    }
}
