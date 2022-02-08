package com.tree.www.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crystal
 * @since 2022/1/14
 */
public class Leetcode373 {
    /**
     * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
     *
     * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
     *
     * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1 [3,4,13,14]
     * @param nums2 [2,4,16,8]
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
        int i = 0, j = 0; boolean flag;
        result.add(wrapperList(nums1[i], nums1[j]));
        if(nums1[i] <= nums2[j]) {
            j ++;
            flag = true;
        } else {
            i ++;
            flag = false;
        }
        while(--k != 0) {
            if(flag) {
                if (nums1[i] + nums2[j] <= nums1[i+1] + nums2[j-1]) {
                    result.add(wrapperList(nums1[i], nums1[j]));
                    if(nums1[i] <= nums2[j]) {
                        j ++;
                    } else {
                        i ++;
                        flag = false;
                    }
                } else {
                    result.add(wrapperList(nums1[i+1], nums1[j-1]));
                    if(nums1[i+1] <= nums2[j-1]) {
                        j ++;
                    } else {
                        i ++;
                        flag = false;
                    }
                }
            } else {
                if (nums1[i] + nums2[j] <= nums1[i-1] + nums2[j+1]) {
                    result.add(wrapperList(nums1[i], nums1[j]));
                    if(nums1[i] <= nums2[j]) {
                        j ++;
                        flag = true;
                    } else {
                        i ++;
                    }
                } else {
                    result.add(wrapperList(nums1[i-1], nums1[j+1]));
                }
            }
        }
        return result;
    }

    private List<Integer> wrapperList(int i, int j) {
        List<Integer> first = new ArrayList<>(2);
        first.add(i);
        first.add(j);
        return first;
    }
}
