package com.tree.www.leetcode;

/**
 * 乘积最大子数组
 * <p>
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * <p>
 * Created by pysh on 2020-05-18.
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -2, 4, 5};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
     * 并返回该子数组所对应的乘积。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            result = Math.max(max, result);
        }
        return result;
    }
}
