package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/8/10.
 */
public class Leetcode413 {
  /**
   * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
   * <p>
   * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
   * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
   * <p>
   * 子数组 是数组中的一个连续序列。
   *
   * @param nums
   * @return
   */
  public int numberOfArithmeticSlices(int[] nums) {
    int len = nums.length, ans = 0;
    if (len < 3) return 0;
    int diff = nums[1] - nums[0], lastCount = 0;
    for (int i = 2; i < len; i++) {
      if (diff == nums[i] - nums[i - 1]) {
        lastCount++;
        ans += lastCount;
      } else {
        diff = nums[i] - nums[i - 1];
        lastCount = 0;
      }
    }
    return ans;
  }
}
