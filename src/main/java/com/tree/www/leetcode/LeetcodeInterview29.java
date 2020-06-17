package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * Created by pysh on 2020-06-12.
 */
public class LeetcodeInterview29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length, column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        int i = 0, j = 0, index = 0, pos = 0;
        int[][] fx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] result = new int[row * column];
        while (index != result.length) {
            visited[i][j] = true;
            result[index++] = matrix[i][j];
            int x = i + fx[pos][0];
            int y = j + fx[pos][1];
            if (x < 0 || y < 0 || x >= row || y >= column || visited[x][y]) {
                pos = (pos + 1) % 4;
                i = i + fx[pos][0];
                j = j + fx[pos][1];
            } else {
                i = x;
                j = y;
            }
        }
        return result;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(--r < l) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if(--b < t) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }


    public static void main(String[] args) {
        final int[] res = new LeetcodeInterview29().spiralOrder2(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(Arrays.toString(res));
    }


}
