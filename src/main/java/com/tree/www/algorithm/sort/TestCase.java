package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * Created by pysh on 2019-05-09.
 */
public class TestCase {

    public static void main(String[] args) {
        int[] toSortArr =// {2, 1, 9, 8, 7, 3, 4, 6, 5, 0};
        {2, 1, -9, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -129, 2, 1, -9, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -1239, 2, 1, -1238, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -9, 11222, 1, -9, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -9, 231223, 1, -9, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -9, 231223, 1, -9, 9, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4
        , 2, 1, -9, 231222, 4, -8, 12, 16, 17, 19, 6, 8, 7, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 5, 3, 2, 11, 14, -3, -2, 3, 4, -10, 20, -10, 3, 4};
        // 冒泡排序
        IArraySort sort = new BubbleSort();
        System.out.println("BubbleSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 选择排序
        sort = new SelectionSort();
        System.out.println("SelectionSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 插入排序
        sort = new InsertSort();
        System.out.println("InsertSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 希尔排序
        sort = new ShellSort();
        System.out.println("ShellSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 归并排序
        sort = new MergeSort();
        System.out.println("MergeSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 快速排序
        sort = new QuickSort();
        System.out.println("QuickSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 堆排序
        sort = new HeapSort();
        System.out.println("HeapSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 计数排序
        sort = new CountingSort();
        System.out.println("CountingSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 桶排序
        sort = new BucketSort();
        System.out.println("BucketSort:" + Arrays.toString(sort.sort(toSortArr)));

        // 基数排序
        sort = new RadixSort();
        System.out.println("RadixSort:" + Arrays.toString(sort.sort(toSortArr)));

    }
}
