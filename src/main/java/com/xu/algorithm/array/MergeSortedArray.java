package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author CharleyXu Created on 2019/3/12.
 * <p>
 * 88 归并两个有序数组
 * <p>
 * 把归并结果存到第一个数组上(假设第一个数组空间足够大)
 * <p>
 * [1,2,3,4,0,0]
 * <p>
 * [4,7,8]
 * <p>
 * result: [1,2,3,4,7,8]
 * <p>
 * leetcode 86
 */
public class MergeSortedArray {

    /**
     * 从尾部遍历,否则在 arr1 上归并得到的值会覆盖还未进行归并比较的值
     */
    public void mergeSortedArray(int[] arr1, int m, int[] arr2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                arr1[mergeIndex--] = arr2[index2--];
            } else if (index2 < 0) {
                arr1[mergeIndex--] = arr1[index1--];
            } else if (arr1[index1] > arr2[index2]) {
                arr1[mergeIndex--] = arr1[index1--];
            } else {
                arr1[mergeIndex--] = arr2[index2--];
            }
        }

    }

    @Test
    public void mergeSortedArrayTest() {
        int[] arr1 = new int[8];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        int[] arr2 = new int[]{4, 7, 8, 10};
        int m = 4;
        int n = 4;
        mergeSortedArray(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
        int[] res = mergeArrays(arr1, m, arr2, n);
        System.out.println(Arrays.toString(res));
    }

    private int[] mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        // 将剩余的元素复制到合并数组中
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }
        return mergedArray;
    }

}
