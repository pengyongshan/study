package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
 * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * Created by pysh on 2020-05-29.
 */
public class Leetcode1371 {

    public int findTheLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        // aeiou5个字母奇偶变更共有00000-11111个状态,
        // 需要长度为32的数组来记录每种状态第一次出现时的位置
        int[] indexF = new int[1 << 5];

        // 初始化起始状态
        Arrays.fill(indexF, Integer.MIN_VALUE);
        int status = 0;//表示000000
        indexF[status] = -1;//因为数组下标是从0开始的，设为0也行下面记录位置时+1就好

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // 状态变更，pre ^ (00001、00010...10000)来求出当前的状态
            if (ch == 'a') {
                status ^= (1);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (indexF[status] != Integer.MIN_VALUE) {
                // 说明此状态已经出现过。
                // 同状态中间的字串必定符合条件，即每个状态都经历了偶数次的变更 => 元音字母出现了偶数次。
                // i - indexF[status]表示字串的长度
                ans = Math.max(ans, i - indexF[status]);
            } else {
                // 第一次出现，记录位置P(f)
                indexF[status] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode1371().findTheLongestSubstring("eleetminicoworoep"));
    }
}
