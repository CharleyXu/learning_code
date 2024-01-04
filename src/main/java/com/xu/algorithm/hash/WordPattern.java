package com.xu.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 290 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * <p>
 * 输出: true
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * <p>
 * 输出: false
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        int n = pattern.length();
        String[] string = s.split(" ");
        if (n != string.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String str = string[i];
            if (c2s.containsKey(c) && !c2s.get(c).equals(str)
                    || s2c.containsKey(str) && !s2c.get(str).equals(c)) {
                return false;
            }
            c2s.put(c, string[i]);
            s2c.put(string[i], c);

        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        List<String> ls = Arrays.asList(s.split(" "));
        int n = pattern.length();
        if (n != ls.size()) return false;
        for (int i = 0; i < n; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != ls.indexOf(ls.get(i)))
                return false;
        }
        return true;
    }
}
