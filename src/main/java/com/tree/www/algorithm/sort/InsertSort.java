package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * Created by pysh on 2019-05-09.
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // 待插入数据

            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1]; // 后移
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
