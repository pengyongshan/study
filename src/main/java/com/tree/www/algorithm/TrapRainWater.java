package com.tree.www.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个m x n的矩阵，其中的值均为正整数，
 * 代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * BFS
 * Created by pysh on 2018/8/21.
 */
public class TrapRainWater {

    public static int trapRainWater(int[][] heights) {

        if (heights == null || heights.length <= 2 || heights[0].length <= 2) {
            return 0;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, Comparator.comparing(a -> a.height));
        int m = heights.length;
        int n = heights[0].length;

        // 从边界最低点开始 比较
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }
        for (int i = 1; i < n - 1; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }


        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 前后左右
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int currentR = cell.row + dir[0];
                int currentC = cell.col + dir[1];
                // 不越界 && 未访问过的
                if (currentR >= 0 && currentR < m && currentC < n && currentC >= 0 && !visited[currentR][currentC]) {
                    visited[currentR][currentC] = true;
                    res += Math.max(0, cell.height - heights[currentR][currentC]);
                    queue.offer(new Cell(currentR, currentC, Math.max(heights[currentR][currentC], cell.height)));
                }
            }
        }
        return res;
    }
}

class Cell {

    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
