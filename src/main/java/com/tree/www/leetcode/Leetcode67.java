package com.tree.www.leetcode;

/**
 * 67. 二进制求和
 * <p>
 * Created by pysh on 2020-03-10.
 */
public class Leetcode67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1011010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
