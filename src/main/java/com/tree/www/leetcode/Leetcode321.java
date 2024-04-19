package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/create-maximum-number/
 * <p>
 * Created by pysh on 12/2/20.
 */
public class Leetcode321 {
    /**
     * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
     * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
     * 要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
     * <p>
     * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
     *
     * @param nums1 [3,4,6,5,5,6,7]
     * @param nums2 [9,1,2,5,8,3]
     * @param k     8
     * @return [9, 8, 6, 5, 5, 6, 7, 3]
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] rest = null;
        int m = nums1.length, n = nums2.length;
        // 从数组nums1选择的数量范围
        int min = Math.max(k - n, 0), max = Math.min(k, m);
        for (int i = min; i <= max; i++) {
            int j = k - i;
            int[] max1 = max(nums1, i);
            int[] max2 = max(nums2, j);
            int[] merged = merge(max1, max2);
            if (rest == null || greater(merged, 0, rest, 0)) {
                rest = merged;
            }
        }
        return rest;
    }

    private static int[] max(int[] nums, int k) {
        int len = nums.length;
        int[] max = new int[k];
        int toRemove = len - k, top = -1;
        for (int num : nums) {
            while (top >= 0 && toRemove > 0 && max[top] < num) {
                top--;
                toRemove--;
            }
            if (top < k - 1) {
                max[++top] = num;
            } else {
                toRemove--;
            }
        }
        return max;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; k < merged.length; k++) {
            merged[k] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return merged;
    }

    private static boolean greater(int[] nums1, int f1, int[] nums2, int f2) {
        while (f1 < nums1.length && f2 < nums2.length && nums1[f1] == nums2[f2]) {
            f1++;
            f2++;
        }
        return f2 == nums2.length || (f1 < nums1.length && nums1[f1] > nums2[f2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(max(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 5)));
    }
}
