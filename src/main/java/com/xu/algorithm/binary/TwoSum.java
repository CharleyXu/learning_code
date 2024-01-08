package com.xu.algorithm.binary;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/2
 * <p>
 * 167 两数之和
 * <p>
 * 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
 * <p>
 * 输入是一个数组(numbers)和一个给定值(target)。输出是两个数的位置，从 1 开始计数。 Input: numbers = [2,7,11,15], target = 9
 * <p>
 * Output: [1,2]
 */
public class TwoSum {

    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1, sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                break;
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    @Test
    public void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

}
