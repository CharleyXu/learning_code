package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/10.
 * <p>
 * 快速排序
 * <p>
 * 基本思想：挖坑填数+分治法(partition)
 * <p>
 * 选一个轴值(pivot，也有叫基准的)，通过一趟排序将待排记录分隔成独立的两部分，
 * <p>
 * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
 */
public class QuickSort extends BaseSort {

    @Test
    public void quicksSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50};
        quicks(arr);
        printArr(arr);
    }

    /**
     * 1. 首先，对原数组执行一次“哨兵划分”，得到未排序的左子数组和右子数组。
     * <p>
     * 2. 然后，对左子数组和右子数组分别递归执行“哨兵划分”。
     * <p>
     * 3. 持续递归，直至子数组长度为 1 时终止，从而完成整个数组的排序。
     */
    public void quicks(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /* 快速排序(尾递归优化) */
    public void quickSort(int[] nums, int left, int right) {
        while (left < right) {
            int pivot = partitions(nums, left, right);
            // 对两个子数组中较短的那个执行快排
            if (pivot - left < right - pivot) {
                quickSort(nums, left, pivot - 1); // 递归排序左子数组
                left = pivot + 1; // 剩余未排序区间为 [pivot + 1, right
            } else {
                quickSort(nums, pivot + 1, right); // 递归排序右子数组
                right = pivot - 1; // 剩余未排序区间为 [left, pivot - 1]
            }

        }
    }

    private void quicks(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partitions(arr, low, high);
        quicks(arr, low, pivot - 1);
        quicks(arr, pivot + 1, high);
    }

    /* 哨兵划分 */
    public int partitions(int[] nums, int left, int right) {
        // 以 nums[left] 作为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--; // 从右向左找首个小于基准数的元素
            }
            while (i < j && nums[i] <= nums[left]) {
                i++; // 从左向右找首个大于基准数的元素
            }
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left); // 将基准数交换至两子数组的分界线
        return i; // 返回基准数的索引
    }

}
