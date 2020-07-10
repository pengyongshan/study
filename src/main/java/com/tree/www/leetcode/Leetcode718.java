package com.tree.www.leetcode;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
 * <p>
 * Created by pysh on 2020-07-01.
 */
public class Leetcode718 {
    public int findLength(int[] A, int[] B) {
        int ans = 0, alen = A.length, blen = B.length, length = alen + blen - 1;
        for (int i = 0; i < length; i++) {
            ans = Math.max(maxLen(i, A, B), ans);
        }
        return ans;
    }

    private int maxLen(int index, int[] A, int[] B) {
        int a = 0, b = 0, len, ans = 0, count = 0;
        if (index < B.length) {
            b = B.length - index - 1;
            len = index + 1;
        } else {
            a = index - B.length + 1;
            len = Math.min(A.length - a, B.length);
        }
        for (int i = 0; i < len; i++) {
            if (A[a + i] == B[b + i]) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 0, 1};
        int[] b = {1, 1, 0, 0, 0};
        System.out.println(new Leetcode718().findLength(a, b));
    }
}
