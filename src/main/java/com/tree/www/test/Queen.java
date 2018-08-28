package com.tree.www.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后问题
 *
 * @author pys
 * @date 2016年5月13日 下午5:12:07
 */
public class Queen {

    public static final int N = 4;

    private int[] column; // 列
    private int[] rup; // \(同一条线上横纵坐标相加相等)
    private int[] lup; // /(同一条线上横纵坐标相减相等)
    private int[] queen; // 解答

    private int num; // 统计解答数

    public Queen() {
        column = new int[N + 1];
        rup = new int[2 * N];
        lup = new int[2 * N];
        queen = new int[N + 1];
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] column, rup, lup, queen;
        column = new int[n + 1];
        rup = new int[2 * n];
        lup = new int[2 * n];
        queen = new int[n + 1];
        List<List<String>> list = new ArrayList<>();
        backTrack(n, 1, column, rup, lup, queen, list);
        return list;
    }

    private static void backTrack(final int n, int j, int[] column, int[] rup, int[] lup, int[] queen, List<List<String>> list) {
        if (j > n) {
            List<String> list1 = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                String string = "";
                for (int k = 1; k <= n; k++) {
                    if (queen[i] == k) {
                        string += "Q";
                    } else {
                        string += ".";
                    }
                }
                list1.add(string);
            }
            list.add(list1);
        } else {
            for (int i = 1; i <= n; i++) {
                if (column[i] == 0 && rup[i + j - 1] == 0 && lup[i - j + n] == 0) {
                    // i-j 范围 -(n-1)到(n-1) 加 n, i+j范围2-2n 所以减1
                    queen[j] = i; // j行i列暂居位置。
                    column[i] = rup[i + j - 1] = lup[i - j + n] = 1; // 同时该位置的列、/和\都不能再放皇后。
                    backTrack(n, j + 1, column, rup, lup, queen, list); // 下一行找
                    column[i] = rup[i + j - 1] = lup[i - j + n] = 0; // 找完一个解恢复原位
                }
            }
        }
    }

    private void showAnswer() {
        System.out.println("第" + ++num + "个解答：");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (queen[i] == j) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
