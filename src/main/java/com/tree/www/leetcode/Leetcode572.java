package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-06-04.
 */
public class Leetcode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right)) {
            return true;
        }
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s != null && t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
