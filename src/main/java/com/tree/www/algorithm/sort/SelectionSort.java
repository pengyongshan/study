package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * Created by pysh on 2019-05-09.
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(arr, min, i);
            }
        }
        return arr;
    }
}
