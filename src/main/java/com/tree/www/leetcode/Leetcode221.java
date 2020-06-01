package com.tree.www.leetcode;

/**
 * 最大正方形
 * <p>
 * Created by pysh on 2020-05-21.
 */
public class Leetcode221 {

    /**
     * 在一个由 0 和 1 组成的二维矩阵内，
     * 找到只包含 1 的最大正方形，并返回其面积。
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int column = matrix[0].length, result = 0;
        for (char[] matrix1 : matrix) {
            if (matrix1[0] == '1') {
                result = 1;
                break;
            }
        }
        for (int i = 1; i < column && result == 0; i++) {
            if (matrix[0][i] == '1') {
                result = 1;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] = (char) (min(min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i][j - 1]) + 1);
                    result = Math.max((matrix[i][j] - '0'), result);
                }
            }
        }
        return result * result;
    }

    private char min(char a, char b) {
        return a < b ? a : b;
    }

}
