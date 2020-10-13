package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * Created by pysh on 2020-07-13.
 */
public class Leetcode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                ans[index++] = nums1[index1];
                index1++;
                index2++;
            } else {
                if(nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        return Arrays.copyOf(ans, index);
    }

    private static int search(int[] a, int value, int left) {
        int right = a.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (a[middle] > value) {
                right = middle - 1;
            } else if (a[middle] < value) {
                left = middle + 1;
            } else {
                return middle + 1;
            }
        }
        return -middle;
    }
}
