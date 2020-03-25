package com.tree.www.leetCode;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * <p>
 * Created by pysh on 2020-03-10.
 */
public class SortColors {

    public static void main(String[] args) {
        sortColors(new int[]{0, 1, 0, 1, 2, 2, 2, 1, 1, 0, 0});
        sortColors2(new int[]{0, 1, 0, 1, 2, 2, 2, 1, 1, 0, 0});
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 进阶：
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */
    public static void sortColors(int[] nums) {
        int p2 = nums.length - 1, p0 = 0, curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                nums[curr] = nums[curr] ^ nums[p0];
                nums[p0] = nums[curr] ^ nums[p0];
                nums[curr] = nums[curr] ^ nums[p0];
                p0++;
                curr++;
            } else if (nums[curr] == 2 && curr != p2) {
                nums[curr] = nums[curr] ^ nums[p2];
                nums[p2] = nums[curr] ^ nums[p2];
                nums[curr] = nums[curr] ^ nums[p2];

                p2--;
            } else {
                curr++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors2(int[] nums) {
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = tmp;

                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = tmp;

                p2--;
            } else curr++;
        }
        System.out.println(Arrays.toString(nums));

    }
}
