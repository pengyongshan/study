package com.tree.www.algorithm;

import java.util.Arrays;

/**
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 * <p>
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 * <p>
 * Created by pysh on 2018/10/29.
 */
public class ArraySameAverage {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(splitArraySameAverage(nums));
    }

    public static boolean splitArraySameAverage(int[] nums) {
        int len = nums.length, sum = 0;
        if (nums.length < 2) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }

        //先排序， 后续递归可以方便剔除多于的分支
        Arrays.sort(nums);
        //迭代i， 对每个i进行回溯
        for (int i = 1; i <= len / 2; i++) {
            //注意这里 sum * i % len == 0的判断: 假设分为i和len-i。 sum / len * i == i个数相加 肯定是整数
            if (sum * i % len == 0 && nsum(nums, sum * i / len, i, 0)) {
                return true;
            }
        }

        return false;
    }

    public static boolean nsum(int[] A, int target, int k, int start) {
        if (k == 0) {
            return target == 0;
        }
        //由于已经排好序， 这种情况就可以排除
        if (A[start] > target / k) {
            return false;
        }

        for (int i = start; i < A.length - k + 1; i++) {
            //剔除多于分支
            if (i > start && A[i] == A[i - 1]) continue;
            if (nsum(A, target - A[i], k - 1, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
