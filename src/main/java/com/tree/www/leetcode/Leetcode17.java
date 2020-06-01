package com.tree.www.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同9宫格）。注意 1 不对应任何字母。
 * <p>
 * Created by pysh on 2020-05-26.
 */
public class Leetcode17 {
    private Map<Character, char[]> map = new HashMap<Character, char[]>() {
        private static final long serialVersionUID = -2757863849791186366L;

        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        bfs("", digits);
        return list;
    }

    private void bfs(String s, String digits) {
        int len = s.length();
        if (len == digits.length()) {
            list.add(s);
            return;
        }
        char[] chars = map.get(digits.charAt(len));
        for (char c : chars) {
            bfs(s + c, digits);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode17().letterCombinations("234"));
    }
}
