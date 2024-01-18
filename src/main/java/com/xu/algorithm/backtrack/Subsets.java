package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/9
 * <p>
 * 78 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> state, List<List<Integer>> res) {
        // 记录解
        res.add(new ArrayList<>(state));
        for (int i = index; i < nums.length; i++) {
            //尝试
            state.add(nums[i]);
            // 下一轮选择
            backtrack(nums, i + 1, state, res);
            // 回退
            state.remove(state.size() - 1);
        }
    }

    /**
     * 时间复杂度 O(n * 2的n次方)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrackWithDup(nums, 0, new ArrayList<>(), res);
        return res;
    }

    /**
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
    private void backtrackWithDup(int[] nums, int index, List<Integer> state, List<List<Integer>> res) {
        // 记录解
        res.add(new ArrayList<>(state));
        for (int i = index; i < nums.length; i++) {
            // 剪枝
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            //尝试
            state.add(nums[i]);
            // 下一轮选择
            backtrackWithDup(nums, i + 1, state, res);
            // 回退
            state.remove(state.size() - 1);
        }
    }

    @Test
    public void subsetsTest() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    @Test
    public void subsetsWithDupTest() {
        // {1,2,2}
        // {4,4,4,1,4}
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

}
