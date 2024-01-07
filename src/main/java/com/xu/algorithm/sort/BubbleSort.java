package com.xu.algorithm.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/12.
 * <p>
 * 冒泡排序
 * <p>
 * 冒泡排序需要两个嵌套的循环. 其中, 外层循环移动游标; 内层循环遍历游标及之后(或之前)的元素,
 * <p>
 * 通过两两交换的方式, 每次只确保该内循环结束位置排序正确,
 * <p>
 * 然后内层循环周期结束, 交由外层循环往后(或前)移动游标, 随即开始下一轮内层循环, 以此类推, 直至循环结束
 */
public class BubbleSort extends BaseSort {

    private void bubbleSort(int[] arr) {
        checkFirst(arr);
        int length = arr.length;
        boolean flag = true;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void bubbleSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
        bubbleSort(arr);
        printArr(arr);
    }

    /**
     *
     * 平均时间复杂度	最好情况  	最坏情况	  空间复杂度
     *     O(n²)	     O(n)	      O(n²)	    O(1)
     *
     */

}
