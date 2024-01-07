package com.xu.algorithm.sort;

import java.util.Arrays;

/**
 * @author CharleyXu Created on 2019/3/10.
 */
public abstract class BaseSort {

    protected void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected void checkFirst(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
    }

    protected void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
