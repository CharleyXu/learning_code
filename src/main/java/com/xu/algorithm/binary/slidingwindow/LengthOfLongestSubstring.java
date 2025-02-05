package com.xu.algorithm.binary.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CharleyXu Created on 2019/2/28.
 * <p>
 * 滑动窗口算法
 * <p>
 * 滑动窗口算法可以用以解决数组/字符串的子元素问题
 * <p>
 * 滑动窗口算法可以将嵌套的for循环问题，转换为单循环问题，降低时间复杂度
 */
public class LengthOfLongestSubstring {

    /**
     * 3. 最长无重复子串
     * <p>
     * 给一个字符串，获得没有重复字符的最长子字符的长度
     *
     * <p>
     * 例子： 输入："abcabcbb" 输出：3
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, ans = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    @Test
    public void lengthSubstringTest() {
        String s = "12314sam222";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
