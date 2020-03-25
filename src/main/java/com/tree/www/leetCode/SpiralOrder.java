package com.tree.www.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pysh on 2020-03-24.
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder(ints));
        generateMatrix(2);
    }

    /**
     * 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int m = matrix.length, n = matrix[0].length, sum = m * n;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int di = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (result.size() < sum) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            if (i + dr[di] < m && j + dc[di] < n
                    && i + dr[di] >= 0 && j + dc[di] >= 0
                    && !visited[i + dr[di]][j + dc[di]]) {
                i = i + dr[di];
                j = j + dc[di];
            } else {
                di = (di + 1) % 4;
                i = i + dr[di];
                j = j + dc[di];
            }
        }

        return result;
    }

    /**
     * 螺旋矩阵 II
     * <p>
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0, j = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int di = 0;
        for (int k = 1, sum = n * n; k <= sum; k++) {
            result[i][j] = k;
            if (i + dr[di] < n && j + dc[di] < n
                    && i + dr[di] >= 0 && j + dc[di] >= 0
                    && result[i + dr[di]][j + dc[di]] == 0) {
                i = i + dr[di];
                j = j + dc[di];
            } else {
                di = (di + 1) % 4;
                i = i + dr[di];
                j = j + dc[di];
            }
        }
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
        return result;
    }
}
