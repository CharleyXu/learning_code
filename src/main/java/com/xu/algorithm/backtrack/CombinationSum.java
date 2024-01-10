package com.xu.algorithm.backtrack;

import java.util.ArrayList;
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
        List<Integer> state = new ArrayList<>();
        backtrack(candidates, 0, target, state, res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> state, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(start));
        } else {
            for (int i = start; i < candidates.length; i++) {
                state.add(candidates[i]);
                // 避免重复使用元素
                backtrack(candidates, i, target - candidates[i], state, res);
                state.remove(state.size() - 1);
            }
        }

    }


}
