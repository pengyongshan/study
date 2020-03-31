package com.tree.www.leetCode;

/**
 * 最小的k个数
 * <p>
 * Created by pysh on 2020-03-30.
 */
public class LeastNumbers {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * <p>
     * 限制：
     * <p>
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        //Arrays.sort(arr);
        int[] rest = new int[k];
        int[] temp = new int[10000];
        for (int i : arr) {
            temp[i]++;
        }
        for (int i = 0; i < temp.length && k > 0; i++) {
            if (temp[i]-- != 0) {
                rest[--k] = i--;
            }
        }
        return rest;
    }
}
