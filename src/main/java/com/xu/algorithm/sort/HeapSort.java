package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/10.
 *
 * 堆排序
 *
 * 堆的含义就是：完全二叉树中任何一个非叶子节点的值均不大于（或不小于）其左，右孩子节点的值
 *
 * 堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。
 *
 * 一是建堆函数，
 *
 * 二是反复调用建堆函数以选择出剩余未排元素中最大的数来实现排序的函数。
 *
 *
 * 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 *
 * 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
 *
 * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 *
 *
 * 建堆，交换.建堆，交换....
 */
public class HeapSort extends BaseSort {

  public void heapSort(int[] arr) {
    checkFirst(arr);
    int len = arr.length - 1;
    /**
     * 1.将数组堆化
     *
     *beginIndex = 第一个非叶子节点。
     *从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大
     */
    int beginIndex = (len - 1) >> 1;
    for (int i = beginIndex; i >= 0; i--) {
      maxHeapify(arr, i, len);
    }
    /**
     * 2.对堆化数据排序
     *
     * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
     * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
     * 直至未排序的堆长度为 0。
     */
    for (int i = len; i > 0; i--) {
      //交换
      swap(arr, 0, i);
      //建堆,每次建堆就可以排除一个元素
      maxHeapify(arr, 0, i - 1);
    }
  }

  /**
   * 完成一次建堆，最大值在堆的顶部(根节点)
   *
   * 完全二叉树特性：
   *
   * 除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐
   *
   * 左边子节点位置 = 当前父节点的两倍 + 1，右边子节点位置 = 当前父节点的两倍 + 2
   *
   * @param arr 看作完全二叉树
   * @param beginIndex 根节点位置
   * @param length 节点总数
   */
  private void maxHeapify(int[] arr, int beginIndex, int length) {
    int left = (beginIndex << 1) + 1;
    int right = left + 1;
    if (left > length) {
      return;
    }
    //子节点值最大索引，默认左子节点
    int max = left;
    if (right <= length && arr[right] > arr[left]) {
      max = right;
    }
    //最大的不是根元素位置，交换
    if (arr[max] > arr[beginIndex]) {
      swap(arr, beginIndex, max);
      //继续比较，直到完成一次建堆
      maxHeapify(arr, max, length);
    }
  }

  @Test
  public void heapSortTest() {
    int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9,
        7, 4, 0, 2, 6};
    heapSort(arr);
    printArr(arr);
  }

  /**
   *
   * ①. 建立堆的过程, 从length/2 一直处理到0, 时间复杂度为O(n);
   * ②. 调整堆的过程是沿着堆的父子节点进行调整, 执行次数为堆的深度, 时间复杂度为O(lgn);
   * ③. 堆排序的过程由n次第②步完成, 时间复杂度为O(nlgn)
   *
   * 平均时间复杂度	最好情况	最坏情况	空间复杂度
   * O(nlog2n)	O(nlog2n)	O(nlog2n)	O(1)
   *
   *  由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列
   */


}
