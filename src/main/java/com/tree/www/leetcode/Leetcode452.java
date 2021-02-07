package com.tree.www.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足 xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 */
public class Leetcode452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 按y升序, 按x升序 [0,11]可能排在[0,6]前面，会导致[0,6]射不到。
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        // 第一箭的极限位置 为排序后的y0。
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            // x < pos(上一箭位置)的都被射爆了， x > pos, 另起一箭pos为当前气球的y。
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
