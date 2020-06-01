package com.tree.www.leetcode;

import java.util.Stack;

/**
 * Created by pysh on 2020-05-30.
 */
public class Leetcode84 {

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * eg:
     * [2,1,5,6,2,3] = 10
     * [2,1,5,2,2,3] = 8
     *
     * @param heights
     * @return
     */
    // 枚举高
    public int largestRectangleArea(int[] heights) {
        int rest = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            int wide = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                wide++;
            }
            for (int k = i + 1; k < len; k++) {
                if (heights[k] < heights[i]) {
                    break;
                }
                wide++;
            }
            rest = Math.max(rest, wide * heights[i]);
        }
        return rest;
    }

    // 单调栈
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }
        // left[i] = {-1, -1, 1, 2, 1, 4}

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        // right[i] = {1, 6, 4, 4, 6, 6}
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(new Leetcode84().largestRectangleArea2(a));
    }
}
