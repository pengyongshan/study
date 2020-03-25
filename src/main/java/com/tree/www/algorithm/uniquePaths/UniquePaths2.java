package com.tree.www.algorithm.uniquePaths;

/**
 * leetcode 不同路径2
 *
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径
 * <p>
 * Created by pysh on 2020-01-19.
 */
public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(test));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            throw new IllegalArgumentException("参数错误");
        }
        int clen = obstacleGrid.length;
        int rlen = obstacleGrid[0].length;

        // 设置第一行
        for (int i = 0; i < rlen; i++) {
            if (obstacleGrid[0][i] == 1) {
                // 有障碍就设为0
                obstacleGrid[0][i] = 0;
            } else {
                // 等于前面一个格子的val
                obstacleGrid[0][i] = i > 0 ? obstacleGrid[0][i - 1] : 1;
            }
        }
        // 设置第一列
        for (int i = 1; i < clen; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 有障碍就设为0
                obstacleGrid[i][0] = 0;
            } else {
                // 等于上面一个格子的val
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }

        for (int i = 1; i < clen; i++) {
            for (int j = 1; j < rlen; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 有障碍就设为0
                    obstacleGrid[i][j] = 0;
                } else {
                    // 等于 (上一个格子的val + 前一个格子的val)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[clen - 1][rlen - 1];
    }
}
