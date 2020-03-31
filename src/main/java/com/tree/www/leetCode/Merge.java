package com.tree.www.leetCode;

/**
 * 合并排序的数组
 * <p>
 * Created by pysh on 2020-03-30.
 */
public class Merge {

    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
     * 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        if (B.length != n || A.length != m + n) return;
        int index = m + n - 1;
        while (n > 0) {
            A[index--] = (m == 0 || B[n - 1] > A[m - 1]) ? B[--n] : A[--m];
        }
        //if (n != 0) System.arraycopy(B, 0, A, 0, n);
    }
}
