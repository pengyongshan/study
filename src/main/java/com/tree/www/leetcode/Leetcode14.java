package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-05-25.
 */
public class Leetcode14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int rowLen = strs.length;
        if (rowLen == 0) return "";
        for (int i = 0, len = strs[0].length(); i < len; i++) {
            char res = strs[0].charAt(i);
            for (int j = 1; j < rowLen; j++) {
                if (strs[j].length() <= i || res != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] param = {"abcde", "abcd", "abcdefghij"};
        System.out.println(new Leetcode14().longestCommonPrefix(param));
    }
}
