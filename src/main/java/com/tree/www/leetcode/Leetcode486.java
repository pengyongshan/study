package com.tree.www.leetcode;

/**
 * 预测赢家
 * <p>
 * Created by pysh on 2020-09-01.
 */
public class Leetcode486 {

    /**
     * 给定一个表示分数的非负整数数组。
     * 玩家 1 从数组任意一端拿取一个分数，
     * 随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
     * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
     * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
     * <p>
     * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
     * <p>
     * 1 <= 给定的数组长度 <= 20.
     * 数组里所有分数都为非负数且不会大于 10000000 。
     * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        System.arraycopy(nums, 0, dp, 0, length);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }

    public boolean PredictTheWinnerOri(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
