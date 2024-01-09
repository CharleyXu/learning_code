package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/11.
 * <p>
 * 归并排序
 * <p>
 * 建立在归并操作上的一种有效的排序算法，1945年由约翰·冯·诺伊曼首次提出。该算法是采用分治法（Divide and Conquer）
 * <p>
 * 的一个非常典型的应用，且各层分治递归可以同时进行
 * <p>
 * <p>
 * 把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
 */
public class MergingSort extends BaseSort {

    /**
     *
     *  平均时间复杂度	  最好情况	  最坏情况	  空间复杂度
     *    O(nlog₂n)	  O(nlog₂n)	  O(nlog₂n)	    O(n)
     *
     *    假设数组长度为n，那么拆分数组共需logn，,
     *
     *    又每步都是一个普通的合并子数组的过程， 时间复杂度为O(n)， 故其综合时间复杂度为O(nlogn)。
     *
     *    另一方面， 归并排序多次递归过程中拆分的子数组需要保存在内存空间， 其空间复杂度为O(n)。
     *
     */

    /**
     * 拆分 + 合并
     */
    public void mergeSortRecursive(int[] arr) {
        checkFirst(arr);
        int length = arr.length;
        int[] result = new int[length];
        mergeSortRecursive(arr, result, 0, length - 1);
    }

    /**
     * 自上而下的递归
     * <p>
     * 通过自上而下的递归实现的归并排序, 将存在堆栈溢出的风险。
     */
    private void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = end + start >> 1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        //拆分
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        //合并
        int k = start;
        //选取两个序列中的较小值放入新数组
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        //序列1中多余的元素移入新数组
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        //序列2中多余的元素移入新数组
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        // result -> arr
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    @Test
    public void mergeSortRecursiveTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
        mergeSortRecursive(arr);
        printArr(arr);
    }

}
