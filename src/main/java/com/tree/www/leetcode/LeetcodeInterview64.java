package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-06-02.
 */
public class LeetcodeInterview64 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、
     * for、while、if、else、switch、case
     * 等关键字及条件判断语句（A?B:C）。
     * <p>
     * n * (n+1) / 2.
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum = n + sumNums(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetcodeInterview64().sumNums(133));
    }
}
