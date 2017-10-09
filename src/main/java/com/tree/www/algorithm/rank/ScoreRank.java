package com.tree.www.algorithm.rank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pysh on 2017/9/18.
 */
public class ScoreRank {
    public static void main(String[] args) throws NumberFormatException, IOException {
        final int MAX = 100;
        final int MIN = 0;

        int[] score = new int[MAX + 1];
        int[] juni = new int[MAX + 2];

        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.print("输入分数，-1结束：");
        do {
            score[count++] = scanner.nextInt();
        } while ((score[count - 1] != -1));

        count--;
        for (int i = 0; i < count; i++) {
            juni[score[i]] ++;
        }
        juni[MAX + 1] = 1;

        for(int i = MAX; i >= MIN; i--) {
            juni[i] += juni[i+1];
        }

        System.out.println("得分\t排行");
        for (int i = 0; i < count; i++) {
            System.out.println(score[i] + "\t" + juni[score[i] + 1]);
        }
    }
}
