package com.tree.www.leetcode;

/**
 * 最佳观光组合
 * <p>
 * Created by pysh on 2020-06-17.
 */
public class Leetcode1014 {

    /**
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     * <p>
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
     * <p>
     * 返回一对观光景点能取得的最高分。
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(A[i] + A[i + 1] - 1, max);
            if (A[i] > A[i + 1]) {
                A[i + 1] = A[i] - 1;
            }
        }
        return max;
    }
}
