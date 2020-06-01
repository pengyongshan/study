package com.tree.www.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysh on 2020-05-23.
 */
public class Leetcode76 {

    public static void main(String[] args) {
        System.out.println(new Leetcode76().minWindow("abcdefac", "ace"));
    }

    /**
     * 给你一个字符串 S、一个字符串 T，
     * 请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * <p>
     * eg:
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * <p>
     * ps:
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 1;
        String result = "";
        if (target.containsKey(s.charAt(0))) current.put(s.charAt(0), 1);
        while (j <= s.length()) {
            if (check(current, target)) {
                if (result.equals("") || result.length() > j - i) {
                    result = s.substring(i, j);
                }
                if (result.length() == t.length()) {
                    return result;
                }
                char key = s.charAt(i++);
                if (current.getOrDefault(key, 0) > 1) {
                    current.put(key, current.get(key) - 1);
                } else {
                    current.remove(key);
                }
                key = s.charAt(i);
                while (!target.containsKey(key) || current.getOrDefault(key, 0) > target.getOrDefault(key, 0)) {
                    if (target.containsKey(key)) {
                        current.put(key, current.getOrDefault(key, 0) - 1);
                    }
                    i++;
                    key = s.charAt(i);
                }
            } else {
                if (j == s.length()) break;
                char key = s.charAt(j);
                while (j++ < s.length() - 1 && !target.containsKey(key)) {
                    key = s.charAt(j);
                }
                current.put(key, current.getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }

    private boolean check(Map<Character, Integer> current, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (!current.containsKey(entry.getKey()) || current.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
