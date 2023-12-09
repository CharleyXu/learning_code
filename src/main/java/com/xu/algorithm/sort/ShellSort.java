package com.xu.algorithm.sort;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/10.
 *
 * 希尔排序，也称递减增量排序算法
 *
 * 第一个突破O(n^2)的排序算法；是简单插入排序的改进版；
 *
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素
 *
 * 步长的选择是希尔排序的重要部分。只要最终步长为1任何步长序列都可以工作。一般来说最简单的步长取值是初次取数组长度的一半为增量
 *
 * ，之后每次再减半，直到增量为1
 */
public class ShellSort extends BaseSort {

  public void shellSort(int[] arr) {
    checkFirst(arr);
    int length = arr.length;
    int gap = length >> 1;
    //不断缩小gap，直到1为止
    for (; gap > 0; gap = gap >> 1) {
      //使用当前gap进行组内插入排序
      for (int i = 0; i + gap < length; i++) {
        for (int j = 0; j + gap < length; j += gap) {
          if (arr[j] > arr[j + gap]) {
            swap(arr, j, j + gap);
          }
        }
      }
    }

  }


  @Test
  public void shellSortTest() {
    int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50};
    shellSort(arr);
    System.out.println(Arrays.toString(arr));

  }

  /**
   * 希尔排序（Wiki官方版）
   *
   * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（注意此算法的gap取值） 2. 按增量序列个数k，对序列进行k 趟排序； 3.
   * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
   *
   * @param arr 待排序数组
   */
  public static void shell_sort(int[] arr) {
    int gap = 1, i, j, len = arr.length;
    int temp;
    while (gap < len / 3) {
      gap = gap * 3 + 1;      // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
    }
    for (; gap > 0; gap /= 3) {
      for (i = gap; i < len; i++) {
        temp = arr[i];
        for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
          arr[j + gap] = arr[j];
        }
        arr[j + gap] = temp;
      }
    }
  }

  /**
   * 最好最坏平均 时间复杂度  O(nlog2 n)
   *
   * 空间复杂度  0(1)
   */

}
