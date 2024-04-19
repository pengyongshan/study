package com.tree.www.leetcode;

import java.util.*;

/**
 * 滑动窗口中位数
 * <p>
 * Created by pysh on 2021/2/3.
 */
public class Leetcode480 {

    /**
     * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
     * <p>
     * 例如：
     * <p>
     * [2,3,4]，中位数是3
     * [2,3]，中位数是 (2 + 3) / 2 = 2.5
     * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
     * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     * <p>
     * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
     * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案
     *
     * @param nums [1,3,-1,-3,5,3,6,7]
     * @param k    3
     * @return [1,-1,-1,3,5,6]
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] result = new double[len - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = calcMedian(i, k, nums);
        }
        return result;
    }

    private double calcMedian(int start, int k, int[] nums) {
        int[] toSortNums = new int[k];
        System.arraycopy(nums, start, toSortNums, 0, k);
        Arrays.sort(toSortNums);
        if (k % 2 == 1) {
            return toSortNums[k / 2];
        } else {
            return toSortNums[k / 2] / 2.0 + toSortNums[k / 2 - 1] / 2.0;
        }
    }

    // 官方题解
    public double[] medianSlidingWindow2(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }
}
