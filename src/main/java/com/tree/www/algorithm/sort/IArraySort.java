package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * Created by pysh on 2019-05-09.
 */
public interface IArraySort {
    int[] sort(int[] sources);

    default void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 扩容并保存数据
    default int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
