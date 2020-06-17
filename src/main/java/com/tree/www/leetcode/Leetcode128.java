package com.tree.www.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pysh on 2020-06-16.
 */
public class Leetcode128 {

    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * <p>
     * 要求算法的时间复杂度为 O(n)。
     * <p>
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int len, max = 0;
        for (Integer set : sets) {
            if (sets.contains(set - 1)) continue;
            len = 1;
            while (sets.contains(++set)) {
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
