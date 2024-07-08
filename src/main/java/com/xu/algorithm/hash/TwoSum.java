package com.xu.algorithm.hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CharleyXu Created on 2019/3/18.
 * <p>
 * leetcode no1
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
        Map<Integer, Integer> map = new HashMap(num.length);
        for (int i = 0, length = num.length; i < length; i++) {
            if (map.containsKey(num[i])) {
                return new int[]{map.get(num[i]), i};
            }
            map.put((target - num[i]), i);
        }
        return new int[]{};
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    @Test
    public void twoSum() {
        int[] ints = twoSum(new int[]{3, 5, 7, 1}, 12);
        Assert.assertArrayEquals(new int[]{1, 2}, ints);
    }
}
