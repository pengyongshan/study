package com.tree.www.algorithm.uniquePaths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * Created by pysh on 2020-01-17.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(7, 3));
        System.out.println(uniquePaths3(7, 5));
    }

    static Map<String, Integer> map = new HashMap<>();

    // 递归 显然f(m,n) = f(m-1,n) + f(m,n-1).和青蛙跳楼梯类似
    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException("参数错误");
        }
        if (m == 1 || n == 1) {
            // 只能一直向右走才能到(1,n)
            // 只能一直向下走才能到(m,1)
            // 通俗点讲就是到第一行或第一列的任意一点都只有1条路径
            return 1;
        }
        // 计算次数较多时递归会超时，由于很多重复计算，用个map缓存下计算结果.空间换时间
        if (map.get(m + "-" + n) != null) {
            return map.get(m + "-" + n);
        }
        int result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(m + "-" + n, result);
        return result;
    }

    // 动态规划1
    public static int uniquePaths2(int m, int n) {
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException("参数错误");
        }
        if (m == 1 || n == 1) {
            // 顶部这行加左边这行都是1.通俗点讲就是到第一行或第一列的任意一点都只有1条路径
            return 1;
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        return result[m - 1][n - 1];
    }

    // 动态规划2, 压缩成一维数组
    public static int uniquePaths3(int m, int n) {
        int[] memo = new int[m];

        // 顶部这行加左边这行都是1.通俗点讲就是到第一行或第一列的任意一点都只有1条路径
        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            // 第二行第二列开始逐行赋值
            for (int j = 1; j < m; j++) {
                // memo[j]赋值时还没被覆盖，保留了同列上一行的记录即上一次循环的数据，
                // memo[j-1]是同行上一列刚赋值的数据
                // 就是递归中的(i,j) = (i-1, j) + (i, j-1)
                memo[j] += memo[j - 1];
            }
        }
        return memo[m - 1];
    }
}
