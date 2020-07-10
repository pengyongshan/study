package com.tree.www.leetcode;

/**
 * 有序矩阵中第K小的元素
 * <p>
 * Created by pysh on 2020-07-02.
 */
public class Leetcode378 {

    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     * <p>
     * 1,2,7
     * 4,16,19
     * 5,17,20
     * k=7。 ans=17
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], r = matrix[matrix.length - 1][matrix[0].length - 1];
        while (l < r) {
            int mid = (l + r) >> 1;
            if (lessThenX4K(mid, matrix, k)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean lessThenX4K(int mid, int[][] matrix, int k) {
        int num = 0, i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= mid) {
                j++;
                num += i + 1;
            } else {
                i--;
            }
        }
        return num < k;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 9}, {4, 16, 19}, {5, 17, 20}};
        System.out.println(new Leetcode378().kthSmallest(a, 7));
    }
}
