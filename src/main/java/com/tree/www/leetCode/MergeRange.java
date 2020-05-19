package com.tree.www.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * <p>
 * Created by pysh on 2020-03-31.
 */
public class MergeRange {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.parallelSort(intervals, Comparator.comparingInt(x -> x[0]));
        int x = intervals[0][0], y = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > y) {
                result.add(new int[]{x, y});
                x = intervals[i][0];
                y = intervals[i][1];
            } else {
                y = Math.max(y, intervals[i][1]);
            }
        }
        result.add(new int[]{x, y});
        return result.toArray(new int[0][]);
    }
}
