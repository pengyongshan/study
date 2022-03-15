package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 打家劫舍 1，2，3
 * <p>
 * Created by pysh on 2019-05-16.
 */
public class HouseRobber {
  /**
   * 给定一个代表每个房屋存放金额的非负整数数组，
   * 计算你在不触动警报装置(相邻会报警)的情况下，能够偷窃到的最高金额。
   *
   * @param nums
   * @return
   */
  public int rob1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    nums[2] = nums[0] + nums[2];
    for (int i = 3; i < nums.length; i++) {
      nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i];
    }
    return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
  }

  /**
   * @param nums 数组首尾相连
   * @return
   */
  public int rob2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] nums1 = Arrays.copyOf(nums, nums.length - 1);
    int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

    return Math.max(rob1(nums1), rob1(nums2));
  }

  /**
   * 给定一颗树
   *
   * @param node
   * @return
   */
  public int rob3(TreeNode node) {
    int[] ret = doRob3(node);
    return Math.max(ret[0], ret[1]);
  }

  // 递归求解
  private int[] doRob3(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    int[] ret = new int[2];
    int[] left = doRob3(node.left);
    int[] right = doRob3(node.right);
    // 不包括根节点, 左边(谁大取谁) + 右边(谁大取谁)
    ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // 包括根节点, val + 不包括根节点的左右
    ret[1] = left[0] + right[0] + node.val;
    return ret;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  TreeNode(int x) {
    val = x;
  }
}
