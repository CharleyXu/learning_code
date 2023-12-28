package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    /**
     * 时间复杂度 O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeArrays(nums1, nums2);
        int length = array.length;
        if (length % 2 == 0) {
            // 如果数组长度为偶数，取中间两个数的平均值
            int mid1 = length / 2;
            int mid2 = mid1 - 1;
            return (array[mid1] + array[mid2]) / 2.0;
        } else {
            // 如果数组长度为奇数，直接取中间的数
            int mid = length / 2;
            return array[mid];
        }
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        // 将剩余的元素复制到合并数组中
        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }
        return mergedArray;
    }
}
