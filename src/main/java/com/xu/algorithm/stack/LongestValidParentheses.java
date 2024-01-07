package com.xu.algorithm.stack;

import org.junit.Test;

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

    /**
     * 使用两个计数器
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 当 right计数器比 left计数器大时，我们将 left和 right 计数器同时变回 0
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 当 left计数器比 right计数器大时，我们将 left和 right 计数器同时变回 0
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;

    }


    @Test
    public void test() {
        System.out.println(longestValidParentheses("(()((()))"));
    }

}
