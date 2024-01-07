package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/12.
 *
 * 折半插入排序
 *
 * 工作原理是通过构建有序序列，对于未排序数据，在已排序序列中采用了折半查找（也称二分查找），
 *
 * 找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
 *
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
 */
public class BinaryInsertionSort extends BaseSort {

  private void binaryInsertionSort(int[] arr) {
    checkFirst(arr);
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int low = 0;
      int high = i - 1;
      //二分查找
      while (high >= low) {
        int mid = (low + high) >> 1;
        if (arr[mid] > temp) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      //已排序元素逐步向后挪位，为最新元素提供插入空间
      for (int j = i; j > low; j--) {
        arr[j] = arr[j - 1];
      }
      arr[low] = temp;
    }
  }

  @Test
  public void binaryInsertionSortTest() {
    int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
    binaryInsertionSort(arr);
    printArr(arr);
  }

  /**
   *
   * 时间复杂度：平均：O(n^2)、最坏：O(n^2)、最优：O(n)。
   * 空间复杂度：O(1)。
   */

}
