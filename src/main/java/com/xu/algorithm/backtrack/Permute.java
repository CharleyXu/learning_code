package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2023/12/9
 * <p>
 * 46 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {

    /**
     * 时间复杂度 O(n×n!)，n 为序列的长度
     * <p>
     * backtrack 的调用次数是 O(n!)
     * <p>
     * 空间复杂度 O(n)，这里需要额外的空间且该空间取决于递归的深度，这里可知递归调用深度为 O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    /* 回溯 */
    private void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 判断是否有解，当状态长度等于元素数量，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝： 不允许重复选择元素
            if (!selected[i]) {
                // 尝试： 做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                //  进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退： 撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }

        }
    }


}
