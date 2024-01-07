package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/11/17
 * <p>
 * 最长回文子串
 */
public class LongestPalindrome {

    @Test
    public void longestPalindromeTest() {
        String res = longestPalindrome1("ddqwed");
        System.out.println(res);
    }

    public String longestPalindrome1(String s) {
        String res = "";
        int n = s.length();
        if(n < 2){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();

        // 单个字符是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 相邻两个字符相同是回文串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1];
                }
                if (dp[i][j] && i - j >= res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        // 单个字符是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 相邻两个字符相同是回文串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // 递推长度大于2的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // 判断子串是否是回文串
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && len > maxLength) {
                    start = i;
                    maxLength = len;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

}
