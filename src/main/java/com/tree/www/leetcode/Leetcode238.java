package com.tree.www.leetcode;


/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * Created by pysh on 2020-06-04.
 */
public class Leetcode238 {

    /**
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * Tips ：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i = len-1; i > 0; i++) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}
