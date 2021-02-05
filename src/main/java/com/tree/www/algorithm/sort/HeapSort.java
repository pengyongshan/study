package com.tree.www.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * Created by pysh on 2019-05-13.
 */
public class HeapSort implements IArraySort {
    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] nums = {4, 5, 2, 7, 1, 22, 13, 14, 5, 8};
        System.out.println(Arrays.toString(sort.sort(nums)));
    }

    @Override
    public int[] sort(int[] sources) {
        int len = sources.length;
        int[] arr = Arrays.copyOf(sources, len);
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    /**
     * 构建大根堆
     * <p>
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     * @param arr
     * @param len
     */
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
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
