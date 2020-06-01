package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-05-21.
 */
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
