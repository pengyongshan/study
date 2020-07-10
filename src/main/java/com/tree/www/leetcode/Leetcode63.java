package com.tree.www.leetcode;

/**
 * 不同路径 II
 * <p>
 * Created by pysh on 2020-07-06.
 */
public class Leetcode63 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     * 说明：m 和 n 的值均不超过 100。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = obstacleGrid[i - 1][0] == 0 || obstacleGrid[i][0] == 1 ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i - 1] == 0 || obstacleGrid[0][i] == 1 ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
