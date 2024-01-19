package com.xu.algorithm.binary;

import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-17
 * <p>
 * 392 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * <p>
 * 使用 双指针
 */
public class IsSubsequence {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列
     * <p>
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true
     * <p>
     * 时间复杂度 O(n+m)
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，
     * <p>
     * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
     * <p>
     * 预处理出对于 t 的每一个位置，从该位置开始往后每一个字符第一次出现的位置。
     * <p>
     * <p>
     * f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
     * <p>
     * 如果 t 中位置 i 的字符就是 j，那么 f[i][j]=i, 否则 j 出现在位置 i+1 开始往后，即 f[i][j]=f[i+1][j]
     *
     * <p>
     * 时间复杂度 O（m * 26 + N)
     */
    public boolean isSubsequence2(String s, String t) {
        // 预处理
        int n = t.length();
        int[][] dp = new int[n + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        // 匹配
        int add = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[add][s.charAt(i) - 'a'] == n) {
                return false;
            }
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    @Test
    public void isSubsequenceTest() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence2("abc", "ahbgdc"));
    }

}
