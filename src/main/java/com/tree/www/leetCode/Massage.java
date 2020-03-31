package com.tree.www.leetCode;

/**
 * 按摩师
 * <p>
 * Created by pysh on 2020-03-26.
 */
public class Massage {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(new Massage().massage(nums));
    }

    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
     * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
     * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * <p>
     * 注意：本题相对原题稍作改动
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2, len = nums.length; i < len; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }
        return nums[nums.length - 1];
        //return max(nums, nums.length-1);
    }

    // 递归法
    private int max(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[i];
        }
        return Math.max(max(nums, i - 1), max(nums, i - 2) + nums[i]);
    }
}