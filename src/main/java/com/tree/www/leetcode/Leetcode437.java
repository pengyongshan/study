package com.tree.www.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysh on 2021/9/28.
 */
public class Leetcode437 {

  /**
   * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
   *
   * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
   *
   * @param root
   * @param targetSum
   * @return
   */
  public int pathSum(TreeNode root, int targetSum) {
    HashMap<Integer, Integer> prefix = new HashMap<>();
    prefix.put(0, 1);
    return dfs(root, prefix, 0, targetSum);
  }

  public int dfs(TreeNode root, Map<Integer, Integer> prefix, int curr, int targetSum) {
    if (root == null) {
      return 0;
    }

    int ret = 0;
    curr += root.val;

    ret = prefix.getOrDefault(curr - targetSum, 0);
    prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
    ret += dfs(root.left, prefix, curr, targetSum);
    ret += dfs(root.right, prefix, curr, targetSum);
    prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

    return ret;
  }
}
