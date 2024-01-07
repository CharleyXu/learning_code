package com.xu.algorithm.twopointer;

/**
 * Created by CharleyXu on 2020-06-17
 * <p>
 * 判断子序列
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
     */
    public boolean isSubsequence(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
            }
            j++;
        }
        return i == a.length;
    }

    // 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，
    //
    // 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    public boolean isSubsequence2(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a') p = i;
            }
        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

}
