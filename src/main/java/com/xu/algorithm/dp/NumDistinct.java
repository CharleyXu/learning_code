package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/19
 * <p>
 * 115 不同的子序列
 * <p>
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10 9 + 7 取模
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * <p>
 * 输出：3
 */
public class NumDistinct {


    /**
     * 时间复杂度
     * <p>
     * dp[i][j] 表示在 s[i:] 子序列中 t[j:] 出现的个数
     * <p>
     * <p>
     * <p>
     * s[i] = t[j]
     * <p>
     * dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
     * <p>
     * s[i] != t[j]
     * <p>
     * dp[i][j] = dp[i + 1][j];
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void numDistinctTest() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

}
