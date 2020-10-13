package com.tree.www.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * Created by pysh on 2020-07-21.
 */
public class Leetcode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new LinkedList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
