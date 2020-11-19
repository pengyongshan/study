package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * <p>
 * Created by pysh on 11/19/20.
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int zero = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                nums[i - zero] = nums[i];
            }
        }
        while (zero-- > 0) {
            nums[--len] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2, 3, 0, 12, 0, 1, 0};
        new Leetcode283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
