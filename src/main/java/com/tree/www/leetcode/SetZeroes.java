package com.tree.www.leetcode;

/**
 * 73. 矩阵置零
 * <p>
 * Created by pysh on 2020-03-10.
 */
public class SetZeroes {

    public static void main(String[] args) {
        int[][] nums = {{0,1,2,0},{3,4,5,5},{1,3,1,5}};
        setZeroes(nums);
    }

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
     * 请使用原地算法。
     * <p>
     * 进阶:
     * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个常数空间的解决方案吗？
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int[] matrix1 : matrix) {
            if (matrix1[0] == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
