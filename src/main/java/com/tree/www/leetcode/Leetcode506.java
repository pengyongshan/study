package com.tree.www.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author crystal
 * @since 2021/12/2
 */
public class Leetcode506 {

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] rest = new String[score.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            map.put(score[i], i);
        }
        int index = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (index == 1) {
                rest[entry.getValue()] = "Gold Medal";
            } else if (index == 2) {
                rest[entry.getValue()] = "Silver Medal";
            } else if (index == 3) {
                rest[entry.getValue()] = "Bronze Medal";
            } else {
                rest[entry.getValue()] = index + "";
            }
            index++;
        }
        return rest;
    }
}
