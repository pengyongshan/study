package com.tree.www.leetcode;

/**
 * Created by pysh on 2021/8/19.
 */
public class Leetcode345 {

  public static void main(String[] args) {
    System.out.println(new Leetcode345().reverseVowels("hello"));
  }

  public String reverseVowels(String s) {
    int len = s.length();
    char[] arr = s.toCharArray();
    int st = 0, en = len - 1;
    while (st < en) {
      while(st < en && !isVowel(arr[st])) {
        st ++;
      }
      while(en > st && !isVowel(arr[en])) {
        en --;
      }
      if(st < en) {
        swap(arr, st, en);
        st ++;
        en --;
      }
    }
    return new String(arr);
  }

  public boolean isVowel(char ch) {
    return "aeiouAEIOU".indexOf(ch) >= 0;
  }

  public void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
