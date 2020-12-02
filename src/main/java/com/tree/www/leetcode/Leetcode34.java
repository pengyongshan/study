package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 12/1/20.
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        int right = binarySearch(nums, target, true);
        if (right == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySearch(nums, target, false), right};
    }

    private int binarySearch(int[] nums, int target, boolean needLast) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target || (needLast && nums[mid] == target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (needLast) {
            return right >= 0 && nums[right] == target ? right : -1;
        } else {
            return left < nums.length && nums[left] == target ? left : -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(new Leetcode34().searchRange(nums, 1)));
    }
}
