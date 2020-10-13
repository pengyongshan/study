package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-07-21.
 */
public class Leetcode312 {

    /**
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
     * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
     * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     * 求所能获得硬币的最大数量。
     * <p>
     * tips:
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100.
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] vals = new int[nums.length + 2];
        vals[0] = vals[nums.length + 1] = 1;
        System.arraycopy(nums, 0, vals, 1, nums.length);
        int[][] dp = new int[vals.length][vals.length];
        for (int i = vals.length - 1; i >= 0; i--) {
            for (int j = i + 2; j < vals.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = vals[i] * vals[j] * vals[k] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][vals.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode312().maxCoins(new int[]{3, 1, 5, 8, 5, 9}));
    }
}
