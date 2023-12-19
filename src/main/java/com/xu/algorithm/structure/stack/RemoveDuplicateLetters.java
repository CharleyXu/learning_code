package com.xu.algorithm.structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/12/14
 * <p>
 * 316. 去除重复字母
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * <p>
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class RemoveDuplicateLetters {

    /**
     * 贪心 + 单调栈
     *
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(26)
     */
    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean[] inStack = new boolean[128];
        // 维护一个计数器记录字符串中字符的数量
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            // 插入之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop 前面的元素
            while (!deque.isEmpty() && deque.peek() > c && count[deque.peek()] != 0) {
                inStack[deque.pop()] = false;
            }
            deque.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }

}
