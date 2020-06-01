package com.tree.www.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * Created by pysh on 2020-05-26.
 */
public class Leetcode287 {
    /**
     * ps:
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n的平方) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1, rest = 0;
        long cnt;
        // 对1-n二分，数组作为判断条件
        while (left <= right) {
            int middle = (left + right) >> 1;
            cnt = Arrays.stream(nums).parallel().filter(n -> n <= middle).count();
            if (cnt > middle) {
                right = middle - 1;
                rest = middle;
            } else {
                left = middle + 1;
            }
        }
        return rest;
    }

    public int findDuplicate2(int[] nums) {
        // 快慢指针找相遇点, 对nums[] 数组建图，每个位置 i 连一条 i→nums[i] 的边
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];// 走2步
        }

        // 一个从起点, 一个从相遇点，再次相遇为环的入口即重复的值
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new Leetcode287().findDuplicate2(new int[]{1, 3, 4, 2, 2}));
    }
}
