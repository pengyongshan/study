package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/8/13.
 */
public class Leetcode233 {

  /**
   * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
   *
   * @param n
   * @return
   */
  public int countDigitOne2(int n) {
    long mulk = 1;
    int ans = 0;
    for (int k = 0; n >= mulk; ++k) {
      ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
      mulk *= 10;
    }
    return ans;
  }

  int[] dp = new int[]{0, 1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000};
  public int countDigitOne(int n) {
    if (n < 10)
      return n == 0 ? 0 : 1;
    String num = String.valueOf(n);
    int length = num.length() - 1, first = num.charAt(0) - '0';
    int firstNum = (int) Math.pow(10, length);
    int nxt = n - firstNum * first;
    return first > 1 ? countDigitOne(nxt) + dp[length] * first + firstNum : countDigitOne(nxt) + dp[length] * first + nxt + 1;
  }

  public static void main(String[] args) {
    System.out.println(new Leetcode233().countDigitOne(13));
  }
}
