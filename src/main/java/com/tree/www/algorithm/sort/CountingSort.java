package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * <p>
 * Created by pysh on 2019-05-13.
 */
public class CountingSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        return countingSort(arr, minValue, maxValue);
    }

    private int[] countingSort(int[] arr, int minValue, int maxValue) {
        int[] bucket = new int[maxValue - minValue + 1];

        for (int value : arr) {
            bucket[value - minValue]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i + minValue;
            }
        }
        return arr;
    }

}
