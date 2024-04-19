package com.tree.www.leetcode;

/**
 * Created by pysh on 11/19/20.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(1234321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int paliandromeNum = 0;
        while (x > paliandromeNum) {
            paliandromeNum = paliandromeNum * 10 + x % 10;
            x = x / 10;
        }
        // 偶数位相等，奇数位 paliandromeNum 需要除10
        return paliandromeNum == x || paliandromeNum / 10 == x;
    }
}
