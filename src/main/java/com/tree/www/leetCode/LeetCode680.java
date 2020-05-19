package com.tree.www.leetCode;

/**
 * Created by pysh on 2020-05-19.
 */
public class LeetCode680 {

    public static void main(String[] args) {
        System.out.println(new LeetCode680().validPalindrome("abca"));
    }

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * <p>
     * ps:字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int len = s.length();
        for (int k = 0; k < len / 2; k++) {
            if (s.charAt(k) != s.charAt(len - 1 - k)) {
                boolean flag = true;
                for (int h = k + 1; h < (len+1) / 2; h++) {
                    if (s.charAt(h) != s.charAt(len - h)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
                flag = true;
                for (int h = k; h < len / 2; h++) {
                    if (s.charAt(h) != s.charAt(len - h - 2)) {
                        flag = false;
                        break;
                    }
                }
                return flag;

            }
        }
        return true;
    }

    public boolean check(String s) {
        int len = s.length();
        for (int k = 0; k <= len / 2; k++) {
            if (s.charAt(k) != s.charAt(len - 1 - k)) {
                return false;
            }
        }
        return true;
    }
}
