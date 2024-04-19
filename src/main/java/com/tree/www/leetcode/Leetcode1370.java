package com.tree.www.leetcode;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string
 * <p>
 * Created by pysh on 11/25/20.
 */
public class Leetcode1370 {

    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     * <p>
     * 1. 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 2. 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 3. 重复步骤 2 ，直到你没法从 s 中选择字符。
     * 4.从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 5. 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 6. 重复步骤 5 ，直到你没法从 s 中选择字符。
     * 7. 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     * <p>
     * 请你返回将 s 中字符重新排序后的 结果字符串 。
     *
     * @param s
     * @return
     */
    public String sortString(String s) {
        if (s == null) return null;
        int[] count = new int[26];
        int len = s.length(), index = 0;
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        char[] res = new char[len];
        while (index < len) {
            // 步骤 1-3
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    res[index++] = (char) (i + 'a');
                    count[i]--;
                }
            }
            // 步骤4-6
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    res[index++] = (char) (i + 'a');
                    count[i]--;
                }
            }
        }
        return new String(res);
    }
}
