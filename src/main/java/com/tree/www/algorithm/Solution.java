package com.tree.www.algorithm;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] pushB = {1, 2, 3, 5, 4};
        int[] area = {5, 2, 3, 5, 4, 3, 2};
        String[] str1 = {"Hello", "world", "java"};
        String[] str2 = {"Veriable", "syntax", "interator"};
        int str1Length = str1.length;
        int str2length = str2.length;

        str1 = Arrays.copyOf(str1, str1Length + str2length);//数组扩容
        System.arraycopy(str2, 0, str1, str1Length, str2length);
        System.out.println(Arrays.toString(str1));

        System.out.println(isPopOrder(pushA, pushB));
        System.out.println(Arrays.toString(twoSum(pushA, 9)));
        System.out.println(maxArea(area));
    }
    /**
     * 寻找2个数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        nums1 = Arrays.copyOf(nums1, length1 + length2);//数组扩容
        System.arraycopy(nums2, 0, nums1, length1, length2);
        Arrays.sort(nums1);
        if (nums1.length % 2 == 0) {
            return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
        }
        return nums1[nums1.length / 2];
    }

    // 3127354
    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int aPushA : pushA) {
            s.push(aPushA);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    /**
     * @param nums
     * @param target
     * @return length = 2 的数组, sum = target
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indexValueMap.containsKey(target - num)) {
                return new int[]{i, indexValueMap.get(target - num)};
            }
            indexValueMap.put(num, i);
        }
        throw new RuntimeException("无解");
    }

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    /**
     * 有效数独校验 9*9
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("参数错误");
        }
        String[] strings = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] > '0' && chars[j] <= '9') {
                    String str = String.valueOf(chars[j]);
                    if (strings[i].contains(str)) {
                        return false;
                    }
                    if (strings[9 + j].contains(str)) {
                        return false;
                    }
                    if (strings[18 + i / 3 * 3 + j / 3].contains(str)) {
                        return false;
                    }
                    strings[i] += str;
                    strings[9 + j] += str;
                    strings[18 + i / 3 * 3 + j / 3] += str;
                }
            }
        }

        return true;
    }
}
