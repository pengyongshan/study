package com.tree.www.leetcode;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * <p>
 * Created by pysh on 2020-03-30.
 */
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(10, 17));
    }

    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。
     * <p>
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
     * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i; // 上一轮的位置
        }
        return ans;
    }

}
