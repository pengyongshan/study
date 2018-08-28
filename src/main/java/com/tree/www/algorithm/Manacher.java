package com.tree.www.algorithm;

import java.util.*;

/**
 * 马拉车算法求字符串最长回文子串
 * <p>
 * Created by pysh on 2018/8/9.
 */
public class Manacher {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String s = scanner.nextLine();
        List<String> result = longestPalindrome(s);
        System.out.println("最长长度:" + result.get(0).length() + ",结果集:" + result);
    }

    public static List<String> longestPalindrome(String s) {
        char[] ori_char = s.toCharArray();
        char[] new_char = init(ori_char);
        int p[] = new int[new_char.length]; // 记录每个节点的回文半径
        int index[] = new int[new_char.length], k = 0; // 多个结果 记录数组下标
        int max_len = 0 , id = 0, mx = 0; // 最长长度, 中心点, 回文串右边界
        for (int i = 1; i < new_char.length - 1; i++) {
            if (i < mx) {
                // 核心代码
                p[i] = Math.min(mx - i, p[2 * id - i]);
            } else {
                p[i] = 1;
            }
            while (new_char[i - p[i]] == new_char[i + p[i]]) {
                p[i]++;
            }
            if (mx < p[i] + i) {
                mx = p[i] + i; // 尽量扩充右边界
                id = i;
            }

            // 结果处理
            if(p[i] - 1 == max_len) {
                index[k++] = i; // 添加结果
            }
            if(p[i] - 1 > max_len) {
                for(int l = 0; l <= k; l++) {
                    index[k] = 0; // 原来的结果集 归0。
                }
                index[0] = i;
                k = 1;
                max_len = p[i] - 1;
            }
        }

        List<String> result = new ArrayList<>();
        String str = String.valueOf(new_char);
        for (int i = 0; i < k; i++) {
            result.add(str.substring(index[i]-max_len, index[i] + max_len).replace("#", ""));
        }
        return result;
    }

    private static char[] init(char[] ori_char) {
        char[] new_char = new char[2 * (ori_char.length + 1) + 1];
        int j = 1;
        new_char[0] = '$'; // 开始
        for (char c : ori_char) {
            new_char[j++] = '#';  // 都弄成奇数回文
            new_char[j++] = c;
        }
        new_char[j++] = '#';
        new_char[j] = '@'; // 结束 比较的时候不需要验证越界
        return new_char;
    }
}
