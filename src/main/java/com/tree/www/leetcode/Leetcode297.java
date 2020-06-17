package com.tree.www.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pysh on 2020-06-16.
 */
public class Leetcode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfsSerialize(root);
    }

    private String dfsSerialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return "null";
        } else {
            return sb.append(node.val).append(",").append(dfsSerialize(node.left)).append(",").append(dfsSerialize(node.right)).toString();
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    private TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Leetcode297().serialize(root));
    }
}
