package com.xu.algorithm.hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CharleyXu Created on 2019/3/18.
 * <p>
 * leetcode no1 两数之和
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * <p>
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>(num.length);
        for (int i = 0, length = num.length; i < length; i++) {
            if (map.containsKey(num[i])) {
                return new int[]{map.get(num[i]), i};
            }
            map.put((target - num[i]), i);
        }
        return new int[]{};
    }

    /**
     * 167 两数之和
     * <p>
     * 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
     * <p>
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数
     * <p>
     * * 输入是一个数组(numbers)和一个给定值(target)。输出是两个数的位置，从 1 开始计数。 Input: numbers = [2,7,11,15], target = 9
     * * <p>
     * * Output: [1,2]
     */
    public int[] twoSum2(int[] numbers, int target) {
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
    public void twoSum() {
        int[] ints = twoSum(new int[]{3, 5, 7, 1}, 12);
        Assert.assertArrayEquals(new int[]{1, 2}, ints);
    }

}
