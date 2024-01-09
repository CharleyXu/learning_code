package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/9
 * <p>
 * 90 子集 II
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * <p>
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsWithDup {

    /**
     * 时间复杂度 O(n * 2的n次方)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> state) {
        res.add(new ArrayList<>(state));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            state.add(nums[j]);
            backtrack(j + 1, nums, res, state);
            state.remove(state.size() - 1);
        }
    }

    @Test
    public void subsetsTest() {
        // {1,2,2}
        // {4,4,4,1,4}
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }


}
