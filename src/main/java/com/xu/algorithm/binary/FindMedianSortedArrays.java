package com.xu.algorithm.binary;

/**
 * Created by CharleyXu on 2023/12/3
 * <p>
 * 4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    /**
     * 二分查找
     * <p>
     * 根据中位数的定义，当 m+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2个元素，
     * <p>
     * 当 m+n 是偶数时，中位数是两个有序数组中的第 (m+n)/2个元素和第 (m+n)/2+1 个元素的平均值。
     * <p>
     * 因此，这道题可以转化成寻找两个有序数组中的第 k 小的数，其中 k 为 (m+n)/2或 (m+n)/2+1
     * <p>
     * 假设两个有序数组分别是 A 和 B。要找到第 k 个元素，我们可以比较 A[k/2−1]和 B[k/2−1]
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    /**
     * 使用归并的方式，合并两个有序数组，得到一个大的有序数组。
     * <p>
     * 大的有序数组的中间位置的元素，即为中位数。
     * <p>
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeArrays(nums1, nums2);

        int length = mergedArray.length;
        if (length % 2 == 0) {
            // 如果数组长度为偶数，取中间两个数的平均值
            int mid1 = length / 2;
            int mid2 = mid1 - 1;
            return (mergedArray[mid1] + mergedArray[mid2]) / 2.0;
        } else {
            // 如果数组长度为奇数，直接取中间的数
            int mid = length / 2;
            return mergedArray[mid];
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
