package com.xu.algorithm.backtrack;

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

    String res = "";

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 0, list);
        return res;
    }

    private void dfs(int n, int k, int depth, List<Integer> list) {
        if (list.size() == n) {
            StringBuilder str = new StringBuilder();
            for (Integer num : list) {
                str.append(num);
            }
            res = new String(str);
            return;
        }
        int cur = factorial(n - depth - 1);
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            if (cur < k) {
                k -= cur;
                continue;
            }
            list.add(i);
            dfs(n, k, depth + 1, list);
        }

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

}
