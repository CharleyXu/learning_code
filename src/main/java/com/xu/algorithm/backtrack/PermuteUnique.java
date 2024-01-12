package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CharleyXu on 2023/12/9
 * <p>
 * <p>
 * 47 全排列II
 * <p>
 * 输入一个整数数组，数组中可能包含重复元素，返回所有不重复的排列。
 */
public class PermuteUnique {

    /* 全排列 II */
    List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    /*  回溯算法:全排列 II
     *  假设元素两两之间互不相同，则 𝑛 个元素共有 𝑛! 种排列(阶乘);
     *
     *  在记录结果时，需要复制长度为 𝑛 的列 表，使用 𝑂(𝑛) 时间。因此时间复杂度为 𝑂(𝑛!𝑛)
     *
     *  最大递归深度为 𝑛 ，使用 𝑂(𝑛) 栈帧空间。
     *  selected 使用 𝑂(𝑛) 空间。同一时刻最多共有 𝑛 个 duplicated，
     *  使用 𝑂(𝑛2) 空间。因此空间复杂度为 𝑂(𝑛2)
     * */
    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        Set<Integer> duplicated = new HashSet<>();
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝:不允许重复选择元素 且 不允许重复选择相等元素
            if (!selected[i] && !duplicated.contains(choice)) {
                // 尝试:做出选择，更新状态
                duplicated.add(choice);
                // 记录选择过的元素值
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退:撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    @Test
    public void permuteUniqueTest() {
        int[] nums = new int[]{1, 3, 3, 5};
        System.out.println(permuteUnique(nums));
    }

}
