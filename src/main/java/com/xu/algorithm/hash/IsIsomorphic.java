package com.xu.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 205. 同构字符串
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 输入：s = "egg", t = "add"
 * <p>
 * 输出：true
 */
public class IsIsomorphic {

    /**
     * 时间复杂度 O(n)
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (s2t.containsKey(c1) && s2t.get(c1) != c2 ||
                    t2s.containsKey(c2) && t2s.get(c2) != c1) {
                return false;
            }
            s2t.put(c1, c2);
            t2s.put(c2, c1);
        }
        return true;
    }
}
