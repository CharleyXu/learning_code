package com.xu.algorithm.tree.bst;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 96 不同的二叉搜索树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 输入 n=3
 * <p>
 * 输出 5
 */
public class NumTrees {

    /**
     * dp[i] 当有i个节点时，一共可以组成的二叉搜索树的数量
     * <p>
     * 以i为根节点的二叉搜索树的数量等于以i-1的总数的二叉搜索树的数量乘以以n-1的二叉搜索树的数量。
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

}
