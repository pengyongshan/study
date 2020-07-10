package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 2020-07-03.
 */
public class Leetcode1300 {

    /**
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
     * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
     * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     * 请注意，答案不一定是 arr 中的数字。
     * <p>
     * <p>
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i], target <= 10^5
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] prex = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prex[i] = prex[i - 1] + arr[i - 1];
        }
        if (prex[len] <= target) {
            return arr[len - 1];
        }
        int except = target / len, sum = getSum(arr, len, prex, except), preSum = sum;
        while (sum < target) {
            sum = getSum(arr, len, prex, ++except);
            if (sum > target) {
                return target - preSum <= sum - target ? except - 1 : except;
            }
            preSum = sum;
        }
        return except;
    }

    private int getSum(int[] arr, int len, int[] prex, int except) {
        int sum;
        int index = Arrays.binarySearch(arr, except);
        if (index < 0) {
            index = -(index + 1);
        }
        sum = prex[index] + except * (len - index);
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new Leetcode1300().findBestValue(arr, 13));
    }
}
