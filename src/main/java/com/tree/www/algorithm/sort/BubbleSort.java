package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * Created by pysh on 2019-05-09.
 */
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int[] arr = Arrays.copyOf(sources, sources.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若比较一轮后为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
