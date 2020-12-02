package com.tree.www.leetcode;

/**
 * Created by pysh on 11/30/20.
 */
public class Leetcode767 {

    /**
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        int len = s.length();
        if (len < 2) return s;
        int[] count = new int[26];
        int threshold = (len + 1) / 2, index = 0, max = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            if (count[c - 'a'] > threshold) return "";
            if (count[c - 'a'] > max) {
                max = count[c - 'a'];
                index = c - 'a';
            }
        }
        char[] rest = new char[len];
        int i = 0;
        while (max-- > 0) {
            rest[i] = (char) (index + 'a');
            i += 2;
        }
        count[index] = 0;
        for (int k = 0; k < 26; k++) {
            while (count[k]-- > 0) {
                if (i >= len) i = 1;
                rest[i] = (char) (k + 'a');
                i += 2;
            }
        }
        return new String(rest);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode767().reorganizeString("zqugrfbsznyiwbokwkpvpmeyvaosdkedbgjogzdpwawwl"));
    }
}
