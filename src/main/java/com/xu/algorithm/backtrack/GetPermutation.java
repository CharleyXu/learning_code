package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/8
 * <p>
 * 60 排列序列
 * <p>
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列 6个
 * <p>
 * 给定 n 和 k，返回第 k 个排列
 * <p>
 * 输入：n = 3, k = 3
 * <p>
 * 输出："213"
 */
public class GetPermutation {

    /**
     * 当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * <p>
     * 输入：n = 3, k = 3
     * 输出："213"
     * <p>
     * 输入：n = 4, k = 9
     * 输出："2314"
     */
    public String getPermutation(int n, int k) {
        return dfs(n, k, 0, new ArrayList<>());
    }

    private String dfs(int n, int k, int depth, List<Integer> state) {
        if (state.size() == n) {
            StringBuilder str = new StringBuilder();
            for (Integer num : state) {
                str.append(num);
            }
            return new String(str);
        }
        // 当前的depth有多少排列数
        int cur = factorial(n - depth - 1);
        for (int i = 1; i <= n; i++) {
            // 剪枝
            if (state.contains(i)) {
                continue;
            }
            // 剪枝，当前的排列组合小于k，跳过该层并重新计算k值
            if (cur < k) {
                k -= cur;
                continue;
            }
            state.add(i);
            return dfs(n, k, depth + 1, state);
        }
        return null;
    }

    /**
     * n!
     */
    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }

    @Test
    public void getPermutationTest() {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(3, 6));
        System.out.println(getPermutation(4, 9));
    }

}
