package com.tree.www.leetcode;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * Created by pysh on 11/23/20.
 */
public class Leetcode242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int len = s.length();
        int [] sn = new int[26], tn = new int[26];
        for(int i = 0; i < len; i++) {
            int si = s.charAt(i) - 'a';
            sn[si] ++;
            int ti = t.charAt(i) - 'a';
            tn[ti] ++;
        }
        for (int i = 0; i < 26; i ++) {
            if(sn[i] != tn[i]) return false;
        }
        return true;
    }
}
