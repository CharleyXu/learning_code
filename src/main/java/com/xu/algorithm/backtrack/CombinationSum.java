package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/9
 * <p>
 * 39 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * <p>
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> state, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(start));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                state.add(candidates[i]);
                // 避免重复使用元素
                backtrack(candidates, i, target - candidates[i], state, res);
                state.remove(state.size() - 1);
            }
        }
    }

    /**
     * 40 组合总和II
     * <p>
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * <p>
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * <p>
     * 回溯 + 剪枝
     * 时间复杂度 O（2的n次方 x n）
     * <p>
     * 空间复杂度 O（n）
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 对 candidates 进行排序
        Arrays.sort(candidates);
        backtrack2(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack2(int[] candidates, int start, int target, List<Integer> state, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(state));
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝 1
            if (target < candidates[i]) {
                break;
            }
            // 剪枝2，避免搜索分支重复，导致产生重复结果，直接跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 尝试
            state.add(candidates[i]);
            // 下一轮选择
            backtrack2(candidates, i + 1, target - candidates[i], state, res);
            // 回退
            state.remove(state.size() - 1);
        }
    }

    @Test
    public void combinationSum2Test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }

}
