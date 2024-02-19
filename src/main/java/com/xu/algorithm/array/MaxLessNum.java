package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/2/19
 * <p>
 * 小于N的最小数
 * <p>
 * 给定一个数字字符串n和一个数组nums，数组中的元素都在0~9之间，
 * 问从数组中选择元素组成的数字，小于n的最大值是多少
 */
public class MaxLessNum {

    int res = 0;

    public int maxLessNum(int[] nums, int n) {
        res = 0;
        // 排序
        Arrays.sort(nums);
        String s = String.valueOf(n);
        // 找到第一个小于N的数
        boolean found = backtrack(nums, s, new ArrayList<>(), true);
        // 如果没找到，说明相同位数没有比N小的，返回少一位的最大值
        if (!found) {
            for (int i = 0; i < s.length() - 1; i++) {
                res = res * 10 + nums[nums.length - 1];
            }
        }
        return res;
    }

    /**
     * 回溯
     */
    private boolean backtrack(int[] nums, String s, List<Integer> state, boolean isEqual) {
        // 记录解
        if (state.size() == s.length()) {
            long stateSum = 0;
            for (Integer num : state) {
                stateSum = stateSum * 10 + num;
            }
            if (stateSum < Integer.parseInt(s)) {
                res = (int) stateSum;
                return true;
            }
            return false;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果上一个数字相等的话，并且当前数字大于n对应的位的话，剪枝
            if (isEqual && nums[i] > s.charAt(state.size()) - '0') {
                continue;
            }
            // 尝试
            state.add(nums[i]);
            // 下一轮选择
            if (backtrack(nums, s, state, nums[i] == s.charAt(state.size() - 1) - '0')) {
                return true;
            }
            // 回退
            state.remove(state.size() - 1);
        }
        return false;
    }

    @Test
    public void maxLessNumTest() {
        int[] nums = new int[]{2, 3, 9};
        int[] nums2 = new int[]{1, 2, 4, 9};
        int[] nums3 = new int[]{1, 2, 4, 3};
        System.out.println(maxLessNum(nums, 322220));
        System.out.println(maxLessNum(nums2, 1111));
        System.out.println(maxLessNum(nums2, 9420));
        System.out.println(maxLessNum(nums3, 578));
    }

}
