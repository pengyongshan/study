package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/6/29.
 */
public class Leetcode168 {
  public static void main(String[] args) {
    System.out.println(convertToTitle(1));
    System.out.println(convertToTitle(26));
    System.out.println(convertToTitle(2626));
    System.out.println(convertToTitle(1111));
  }

  /**
   * 1-A
   * 26-Z
   * 27-AA
   * @param columnNumber
   * @return
   */
  public static String convertToTitle(int columnNumber) {
    StringBuilder sb = new StringBuilder();
    while (columnNumber != 0) {
      columnNumber--;
      sb.append((char)(columnNumber % 26 + 'A'));
      columnNumber /= 26;
    }
    return sb.reverse().toString();
  }
}
