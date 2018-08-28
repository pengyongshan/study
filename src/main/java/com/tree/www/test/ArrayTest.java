package com.tree.www.test;

/**
 * Created by pysh on 2018/6/15.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(sumArrayOfDiagonal(arr));
    }

    public static int sumArrayOfDiagonal(int[][] arr) {
        if (arr.length != arr[0].length) {
            throw new RuntimeException("数组不合法");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i];
            }
        }
        return sum;
    }
}
