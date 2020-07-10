package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-06-19.
 */
public class Leetcode125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.trim().equals("")) return true;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }
            if (Character.toLowerCase(chars[l++]) != Character.toLowerCase(chars[r--])) return false;
        }
        return true;
    }
}
