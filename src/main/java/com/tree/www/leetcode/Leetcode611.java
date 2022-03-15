package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 2021/8/4.
 */
public class Leetcode611 {
  /**
   * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   *
   * @param nums
   * @return
   */
  public int triangleNumber(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int ans = 0;
    for (int i = 0; i < n-2; ++i) {
      int k = i+1;
      for (int j = i + 1; j < n; ++j) {
        while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
          ++k;
        }
        ans += Math.max(k - j, 0);
      }
    }
    return ans;
  }
}
