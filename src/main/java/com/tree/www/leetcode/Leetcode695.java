package com.tree.www.leetcode;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1
 * 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * Created by pysh on 2020-06-01.
 */
public class Leetcode695 {

    int[][] dp = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        if (grid == null || grid.length == 0) {
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(i, j, grid));
                }
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] grid) {
        int area = 1;
        grid[i][j] = 0; // 访问过就标为0
        for (int[] move : dp) { // 再搜索上下左右
            int x = i + move[0], y = j + move[1];
            if (x < grid.length && x >= 0
                    && y >= 0 && y < grid[0].length) {
                if (grid[x][y] == 1) {
                    area += dfs(x, y, grid);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1}};
        System.out.println(new Leetcode695().maxAreaOfIsland(nums));
    }
}
