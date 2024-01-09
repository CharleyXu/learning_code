package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Integer> state = new ArrayList<>(); // 状态(子集)
        backtrack(0, nums, res, state);
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> state) {
        res.add(new ArrayList<>(state));
        for (int j = i; j < nums.length; j++) {
            //尝试
            state.add(nums[j]);
            // 下一轮选择
            backtrack(j + 1, nums, res, state);
            // 回退
            state.remove(state.size() - 1);
        }
    }

    @Test
    public void subsetsTest() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

}
