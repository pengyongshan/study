package com.tree.www.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 组合总和
 * <p>
 * Created by pysh on 11/18/20.
 */
public class Leetcode39 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有
     * 可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode39 solution = new Leetcode39();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }
}
