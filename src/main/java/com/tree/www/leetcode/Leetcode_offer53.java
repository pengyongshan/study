package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * Created by pysh on 2021/7/16.
 */
public class Leetcode_offer53 {

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    System.out.println("value: 8, count:" + search(nums, 8));
    System.out.println("value: 8, count:" + search2(nums, 8));
  }

  public static int search(int[] nums, int target) {
    int index = Arrays.binarySearch(nums, target);
    if(index < 0) return 0;
    int count = 1, t = index;
    while(--t >= 0 && nums[t] == target) {
      count++;
    }
    while(++index < nums.length && nums[index] == target) {
      count++;
    }
    return count;
  }

  public static int search2(int[] nums, int target) {
    return helper(nums, target) - helper(nums, target - 1);
  }

  static int helper(int[] nums, int tar) {
    int i = 0, j = nums.length - 1;
    while(i <= j) {
      int m = (i + j) / 2;
      if(nums[m] <= tar) i = m + 1;
      else j = m - 1;
    }
    return i;
  }
}
