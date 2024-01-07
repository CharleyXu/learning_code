package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/12.
 * <p>
 * 插入排序
 * <p>
 * 基本思想是：将数组中的所有元素依次跟前面已经排好的元素相比较，
 * <p>
 * 如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止
 */
public class InsertionSort extends BaseSort {

    /**
     * 时间复杂度：平均：O(n^2)、最坏：O(n^2)、最优：O(n)。
     * 空间复杂度：O(1)
     * <p>
     * 最好情况，比较次数(KCN)：n−1；移动次数(RMN)为0。则对应的时间复杂度为O(n)。
     */
    private void insertionSort(int[] arr) {
        checkFirst(arr);
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 二分插入排序
     */
    private void binaryInsertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int binary = findByBinary(arr, i);
            int key = arr[i];
            int j = i - 1;
            while (j >= binary) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[binary] = key;
        }
    }

    private int findByBinary(int[] arr, int i) {
        int left = 0;
        int high = i - 1;
        int mid;
        while (left <= high) {
            mid = (left + high) >> 1;
            if (arr[i] >= arr[mid]) {
                // 若相等，保证新元素插在旧元素后面
                left = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void insertionSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
        insertionSort(arr);
        printArr(arr);
    }


    @Test
    public void binaryInsertionSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
        binaryInsertSort(arr);
        printArr(arr);
    }

}
