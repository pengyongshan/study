package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 桶排序
 * <p>
 * Created by pysh on 2019-05-13.
 */
public class BucketSort implements IArraySort {

    private static final InsertSort INSERT_SORT = new InsertSort();

    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);
        int bucketSize = arr.length / 10;
        return bucketSort(arr, bucketSize > 5 ? bucketSize : 5);
    }

    private int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 1) {
            return arr;
        }

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

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int value : arr) {
            int index = (value - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], value);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }
            bucket = INSERT_SORT.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

}
