package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/3
 * <p>
 * 77 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 输入：n = 4, k = 2
 * <p>
 * 输出：
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), n, k, 1, res);
        return res;
    }

    /* 回溯 */
    private void backtrack(List<Integer> state, int n, int k, int begin, List<List<Integer>> res) {
        if (state.size() == k) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = begin; i <= n; i++) {
            // 剪枝： 不允许重复选择元素
            // 尝试： 做出选择，更新状态
            state.add(i);
            // 进行下一轮选择
            backtrack(state, n, k, i + 1, res);
            // 回退： 撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

    @Test
    public void combineTest() {
        System.out.println(combine(4, 2));
    }

}
