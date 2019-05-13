package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 快排
 * <p>
 * Created by pysh on 2019-05-10.
 */
public class QuickSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pIndex = partition(arr, left, right);
            quickSort(arr, left, pIndex - 1);
            quickSort(arr, pIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for(int i = index; i <= right; i++) {
            if(arr[i] < arr[left]) {
                swap(arr, i, index);
                index ++;
            }
        }
        swap(arr, left, index-1);
        return index -1;
    }

}
