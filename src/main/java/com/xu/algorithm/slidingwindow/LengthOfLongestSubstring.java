package com.xu.algorithm.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
     * 没有重复字符的子字符的最大长度：给一个字符串，获得没有重复字符的最长子字符的长度
     * <p>
     * 例子： 输入："abcabcbb" 输出：3
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        Set<Character> characterSet = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        int length = s.length();
        while (i < length && j < length) {
            //窗口的左边是i，右边是j，下列算法将窗口的左右移动，截取出其中一段
            // try to extend the range [i, j]
            if (!characterSet.contains(s.charAt(j))) {
                characterSet.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                characterSet.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);
            //
            while (map.get(right) > 1) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    @Test
    public void lengthSubstringTest() {
        String s = "12314sam222";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
        int res = lengthOfLongestSubstring2(s);
        System.out.println(res);
    }
}
