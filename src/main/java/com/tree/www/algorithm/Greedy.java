package com.tree.www.algorithm;

/**
 * 贪心算法
 * <p>
 * Created by pysh on 2019-06-04.
 */
public class Greedy {

    public static void main(String[] args) {
        int[] s = {0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        boolean[] b = new boolean[s.length];
        activity_selector(s, f, b);
        System.out.println(cut_rope(11));
    }

    // 活动选择问题
    private static void activity_selector(int[] s, int[] f, boolean[] b) {
        int n = s.length - 1;
        b[1] = true;
        int j = 1;
        for (int i = 2; i <= n; i++) {
            if (s[i] > f[j]) {
                b[i] = true;
                j = i;
            } else {
                b[i] = false;
            }
        }

        for (int i = 1; i < b.length; i++) {
            System.out.print(b[i] + ",");
        }
    }

    /**
     * 给你一个长度为n的绳子，请把绳子剪成m段（m，n都是整数，且都大于1）
     * 每段绳子的长度即为K[0],K[1],K[2]...K[m]。请问K[0]*k[1]..*k[m]可能的最大乘积是多少？
     * <p>
     * 通过局部最优解来得到全局最优解,对于分割问题来说,要使乘积最大,该问题的贪心思想是尽可能去剪为长度为3的绳子!
     *
     * @param n
     * @return
     */
    private static int cut_rope(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
