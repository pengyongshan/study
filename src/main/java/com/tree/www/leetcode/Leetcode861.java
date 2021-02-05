package com.tree.www.leetcode;

/**
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * <p>
 * Created by pysh on 12/7/20.
 */
public class Leetcode861 {

    /**
     * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
     * <p>
     * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     * <p>
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
     * <p>
     * 返回尽可能高的分数
     * <p>
     * <p>
     * 1. 每行第一个转为1
     * 2. 每列0多就转，0少忽略
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int m = A.length, n = A[0].length;
        // 每行第一个转为1, 第一列之和
        int rest = m * (1 << n - 1);

        // 从第二列开始循环
        for (int i = 1; i < n; i++) {
            int oneNum = 0;
            for (int[] num : A) {
                // 与每行开头相等((0，0)一开始转为(1,1)或本来就是(1,1)不变， 1的数量加1.
                if (num[i] == num[0]) {
                    oneNum++;
                }
            }
            // 该列1的数量少就转换列 取多的。
            rest += Math.max(oneNum, m - oneNum) * (1 << n - 1 - i);
        }
        return rest;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(new Leetcode861().matrixScore(a));
    }
}
