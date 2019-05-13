package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * Created by pysh on 2019-05-13.
 */
public class HeapSort implements IArraySort {
    @Override
    public int[] sort(int[] sources) {
        int len = sources.length;
        int[] arr = Arrays.copyOf(sources, len);
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    /**
     * 构建大根堆
     *
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     * @param arr
     * @param len
     */
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    // 堆化
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
}
