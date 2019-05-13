package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * <p>
 * Created by pysh on 2019-05-10.
 */
public class ShellSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);

        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = gap /2;
        }
        return arr;
    }
}
