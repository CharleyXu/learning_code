package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2018/3/7.
 */
public class BinarySearch {

    /**
     * 二分查找
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    @Test
    public void binarySearchTest() {
        int[] arr = {1, 3, 6, 8, 12, 5, 1};
        int data = 6;
        System.out.println(binarySearch(arr, data));
    }
}
