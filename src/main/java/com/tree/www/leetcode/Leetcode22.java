package com.tree.www.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Created by pysh on 2020-07-02.
 */
public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, int l, int r, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            backtrack(ans, sb, l + 1, r, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            backtrack(ans, sb, l, r + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
