package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.*;

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

    /**
     * 140 单词拆分 II
     * <p>
     * 给定一个字符串 s 和一个字符串字典 wordDict ，
     * <p>
     * 在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     * <p>
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * <p>
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * <p>
     * 输出:["cats and dog","cat sand dog"]
     */
    public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new LinkedList<>(), wordDictSet, res);
        return res;
    }

    private void backtrack(String s, int index, List<String> path,
                           Set<String> wordDictSet, List<String> res) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (wordDictSet.contains(str)) {
                path.add(str);
                backtrack(s, i + 1, path, wordDictSet, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<String> wordBreakII2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        return backtrack2(s, wordDictSet, 0);
    }

    private List<String> backtrack2(String s, Set<String> wordDictSet, int start) {
        List<String> res = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!wordDictSet.contains(str)) {
                continue;
            }
            if (i == s.length()) {
                res.add(str);
            } else {
                List<String> backtracks = backtrack2(s, wordDictSet, i);
                for (String backtrack : backtracks) {
                    res.add(str + " " + backtrack);
                }
            }
        }
        return res;
    }

    @Test
    public void wordBreakIITest() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreakII(s, wordDict));
        System.out.println(wordBreakII2(s, wordDict));
    }

}
