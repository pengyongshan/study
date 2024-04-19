package com.tree.www.leetcode;

import java.util.*;

/**
 * Created by pysh on 2021/7/19.
 */
public class Leetcode1838 {

  public static void main(String[] args) {
    //List<String> list = new ArrayList<>();
    //list.add("a");
    //list.add("b");
    //list.add("c");
    //list.add("d");
    //list.add("e");
    //list.add("f");
    //list.forEach(s-> System.out.println(Thread.currentThread().getName() + s));
    System.out.println(getDate(0));
    System.out.println(getDate(-1));
    System.out.println(getDate(-7));
  }
  public static Date getDate(int date) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, date);
    calendar.add(Calendar.MINUTE, -1);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE), 0);
    return calendar.getTime();
  }
  /**
   * 元素的 频数 是该元素在一个数组中出现的次数。
   *
   * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
   *
   * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数
   */
  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    long total = 0;
    int l = 0, res = 1;
    for (int r = 1; r < n; ++r) {
      total += (long) (nums[r] - nums[r - 1]) * (r - l);
      while (total > k) {
        total -= nums[r] - nums[l];
        ++l;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
}
