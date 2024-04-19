package com.tree.www.leetcode;

/**
 * Created by pysh on 2020/12/23.
 */
public class Leetcode387 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s != null && s.length() != 0) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }

            for (int i = 0, len = s.length(); i < len; i++) {
                char c = s.charAt(i);
                if (counts[c - 'a'] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
