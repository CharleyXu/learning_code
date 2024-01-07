package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/12.
 *
 * 鸡尾酒排序  搅拌排序
 *
 * 与冒泡排序的不同处在于排序时是以双向在序列中进行排序
 */
public class CocktailSort extends BaseSort {

  public void cocktailSort(int[] arr) {
    checkFirst(arr);
    int i, left = 0, right = arr.length - 1;
    while (left < right) {
      for (i = left; i < right; i++) {
        if (arr[i] > arr[i + 1]) {
          swap(arr, i, i++);
        }
      }
      right--;

      for (i = right; i > left; i--) {
        if (arr[i - 1] > arr[i]) {
          swap(arr, i - 1, i);
        }
      }
      left++;
    }

  }

  @Test
  public void cocktailSortTest() {
    int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
    cocktailSort(arr);
    printArr(arr);
  }

  /**
   *
   * 时间复杂度：平均：O(n^2)、最坏：O(n^2)、最优：O(n)。
   * 空间复杂度：O(1)
   *
   */

}
