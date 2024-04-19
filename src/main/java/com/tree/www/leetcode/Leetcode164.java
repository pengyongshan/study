package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 11/26/20.
 */
public class Leetcode164 {
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * 如果数组元素个数小于 2，则返回 0。
     *
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     * @param
     */
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i]-nums[i-1]);
        }
        return result;
    }
}
