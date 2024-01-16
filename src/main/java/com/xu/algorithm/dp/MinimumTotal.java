package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * <p>
 * 输出：11
 * <p>
 * 2+3+5+1
 */
public class MinimumTotal {

    /**
     * Dp
     * <p>
     * dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j]
     * <p>
     * 时间复杂度 O(N2)
     * <p>
     * 空间复杂度 O(N2)
     */
    public int minimumTotalDp(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 从点[i,j] 到 底边的最小路径和
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * Dp 空间优化
     * <p>
     * dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j]
     * <p>
     * 计算dp[i][j]时，只用到了下一行的dp[i+1][j],dp[i+1][j+1]
     * <p>
     * 不需要定义N行，只定义1行
     * <p>
     * 时间复杂度 O(N2)
     * <p>
     * 空间复杂度 O(N)
     */
    public int minimumTotalDp2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 从点[i,j] 到 底边的最小路径和
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 记忆化搜索
     * <p>
     * 时间复杂度 O(N2)
     */
    Integer[][] memo;

    public int minimumTotalMemo(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfsMemo(triangle, 0, 0);
    }

    private int dfsMemo(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * dfs
     * f(i,j)为 （i，j）点到底边的最小路径和
     */
    public int minimumTotalDfs(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    @Test
    public void minimumTotalTest() {
        List<List<Integer>> integers = new ArrayList<>();
        integers.add(Arrays.asList(2));
        integers.add(Arrays.asList(3, 4));
        integers.add(Arrays.asList(6, 5, 7));
        integers.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotalDfs(integers));
        System.out.println(minimumTotalMemo(integers));
        System.out.println(minimumTotalDp(integers));
        System.out.println(minimumTotalDp2(integers));
    }

}
