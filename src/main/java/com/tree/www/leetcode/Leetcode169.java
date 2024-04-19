package com.tree.www.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author crystal
 * @since 2021/12/2
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int rest = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                rest = num;
            }
            count += (num == rest) ? 1 : -1;
        }
        return rest;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode169().majorityElement2(new int[]{1, 12, 1, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2}));
    }

}
