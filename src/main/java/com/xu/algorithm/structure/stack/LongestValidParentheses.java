package com.xu.algorithm.structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 32. 最长有效括号
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // （下标放入栈
                deque.push(i);
            } else {
                // 先弹出栈顶元素表示匹配了当前右括号
                deque.pop();
                // 更新「最后一个没有被匹配的右括号的下标」
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    // 计算有效连续长度，取最大值
                    res = Math.max(res, i - deque.peek());
                }
            }
        }
        return res;
    }

}
