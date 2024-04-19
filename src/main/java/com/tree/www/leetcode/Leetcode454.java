package com.tree.www.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * <p>
 * Created by pysh on 11/27/20.
 */
public class Leetcode454 {
    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
     * 使得 A[i] + B[j] + C[k] + D[l] = 0。
     * <p>
     * <p>
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
     * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     * <p>
     * <p>
     * [1,2]
     * [-2,-1]
     * [-1,2]
     * [0,2]
     * <p>
     * (-1,1),(0,2),(1,1)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) return 0;
        int rest = 0, key;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                key = i + j;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        for (int i : C) {
            for (int j : D) {
                key = -i - j;
                if (map.containsKey(key)) {
                    rest += map.get(key);
                }
            }
        }
        return rest;
    }
}
