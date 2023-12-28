package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2023/12/28
 * <p>
 * 18
 * <p>
 * 4 Sum
 * <p>
 * * 给定一个n个整数的数组S，是否存在S中的元素 a，b，c和d，
 * <p>
 * 使得a + b + c + d = target？在数组中找出所有唯一的四元组，给出目标的总和。
 */
public class FourSum {

    /**
     * 先排序 + 双指针
     * <p>
     * 时间复杂度 O（n3）
     * 空间复杂度 O（n）
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int n = nums.length, left, right, temp;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 2] + nums[j + 3] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                left = j + 1;
                right = n - 1;
                temp = target - nums[i] - nums[j];
                while (left < right) {
                    if (temp == nums[left] + nums[right]) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (temp < nums[left] + nums[right]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] num = {1, 0, -1, 0, -2, 2};
        int[] num2 = {-3, -3, 1, 0, -1, 0, 0, 0, 0, 1, 1, -2, 2, 3, 3, 3, 3, 4};
        int[] num3 = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        int target = 0;
        List<List<Integer>> list = fourSum(num2, 12);
        System.out.println(list);
    }


}
