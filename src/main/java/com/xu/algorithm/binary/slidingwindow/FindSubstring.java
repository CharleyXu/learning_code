package com.xu.algorithm.binary.slidingwindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 30 串联所有单词的子串
 * <p>
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * <p>
 * 输出：[0,9]
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return ans;
        }
        // 所有单词个数
        int n = words.length;
        // 单词长度
        int wordLen = words[0].length();
        // 滑动窗口总长度
        int windowLen = n * wordLen;
        // 字符串长度
        int sLen = s.length();
        // 记录每个单词出现的频率
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        // 遍历s
        for (int i = 0; i < sLen - windowLen + 1; i++) {
            // 窗口
            String str = s.substring(i, i + windowLen);
            Map<String, Integer> hashMap = new HashMap<>(wordMap);
            // 子串和临时map进行比较
            for (int j = 0; j < str.length(); j += wordLen) {
                String word = str.substring(j, j + wordLen);
                if (hashMap.containsKey(word)) {
                    hashMap.put(word, hashMap.get(word) - 1);
                    if (hashMap.get(word) == 0) {
                        hashMap.remove(word);
                    }
                } else {
                    break;
                }
            }
            // 临时map为空，表示全部匹配，记录下标
            if (hashMap.isEmpty()) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 朴素Hash
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        out:
        for (int i = 0; i + m * w <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + m * w);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) {
                    continue out;
                }
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cur.equals(map)) ans.add(i);
        }
        return ans;
    }


    @Test
    public void findSubstringTest() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(findSubstring(s, words));
        System.out.println(findSubstring2(s, words));
    }

}
