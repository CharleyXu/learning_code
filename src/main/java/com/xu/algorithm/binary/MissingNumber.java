package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-17
 * <p>
 * 0～n-1中缺失的数字
 */
public class MissingNumber {

    /**
     * 输入: [0,1,2,3,4,5,6,7,9]
     * <p>
     * 输出: 8
     */
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (middle == nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    @Test
    public void missingNumberTest() {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }

}
