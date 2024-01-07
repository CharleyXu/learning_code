package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/10.
 *
 * 选择排序
 *
 * 选择排序的基本思想：比较 + 交换。
 *
 * 在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置。
 */
public class SelectionSort extends BaseSort {

  public void selectionSort(int[] arr) {
    checkFirst(arr);
    int length = arr.length;
    int min;
    for (int i = 0; i < length; i++) {
      // 初始化未排序序列中最小数据数组下标
      min = i;
      for (int j = i + 1; j < length; j++) {
        if (arr[j] < arr[min]) {
          // 在未排序元素中继续寻找最小元素，并保存其下标
          min = j;
        }
      }
      if (min != i) {
        swap(arr, min, i);
      }
    }

  }

  @Test
  public void selectionSortTest() {
    int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50};
    selectionSort(arr);
    printArr(arr);
  }

  /**
   * 最好最坏平均 时间复杂度  O(n2)
   *
   * 空间复杂度  0(1)
   */
}
