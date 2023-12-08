package com.xu.algorithm.dp;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 最长公共子序列
 */
public class LongestCommonSubsequence {

    /**
     * 时间复杂度：O（mn）
     * 空间复杂度：O（mn）
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 定义 dp[i][j]表示字符串text1的[0,i]区间和字符串text2的[0,j]区间的最长公共子序列长度（下标从1开始）
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
