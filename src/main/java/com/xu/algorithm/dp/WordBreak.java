package com.xu.algorithm.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CharleyXu on 2024/1/11
 * <p>
 * 139 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * <p>
 * 输出: true
 * <p>
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class WordBreak {

    /**
     * dp[i] 表示 字符串前i个字符经过拆分是否存在于字典中
     * <p>
     * 向前截取k个字符, 判断[i-k+1,i] 是否存在字典中
     * <p>
     * dp[i] = dp[i-k] && dict.contains(s.substring(i-k,i))
     * <p>
     * 时间复杂度 O(n2)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n];
    }

}
