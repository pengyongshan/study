package com.tree.www.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * Created by pysh on 2020-03-27.
 */
public class FourSum {

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) return Collections.emptyList();
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] + nums[3] > target) return Collections.emptyList();
        if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) return Collections.emptyList();

        List<List<Integer>> rest = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            // 同上
            if (i != 0 && nums[i] == nums[i - 1]) continue; // 去重
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) continue; // 最小 > 目标
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue; // 最大 < 目标

            for (int j = i + 1; j < len - 2; j++) {
                // 同上
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) continue;
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;

                for (int k = j + 1; k < len - 1; k++) {
                    // 同上
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] + nums[k+1] > target) continue;
                    if (nums[i] + nums[j] + nums[k] + nums[len - 1] < target) continue;

                    for (int l = k + 1; l < len; l++) {
                        if (l != k+1 && nums[l] == nums[l - 1]) continue;
                        if (nums[i] + nums[j] + nums[k] + nums[l] > target) break;
                        if (target == nums[i] + nums[j] + nums[k] + nums[l]) {
                            rest.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            break;
                        }
                    }
                }
            }
        }
        return rest;
    }
}
