package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/17
 * <p>
 * 301 删除无效的符号
 * <p>
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * <p>
 * 输入：s = "()())()"
 * <p>
 * 输出：["(())()","()()()"]
 */
public class RemoveInvalidParentheses {

    /**
     * 回溯 + 剪枝
     * <p>
     * 先利用括号匹配的规则求出该字符串 s 中最少需要去掉的左括号的数目 left 和右括号的数目 right，然后我们尝试在原字符串 s 中去掉 left个左括号和 right 个右括号，然后检测剩余的字符串是否合法匹配，
     * <p>
     * 如果合法匹配则我们则认为该字符串为可能的结果，我们利用回溯算法来尝试搜索所有可能的去除括号的方案
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        backtrack(s, 0, left, right, ans);
        return ans;
    }

    private void backtrack(String s, int start, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 跳过
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 如果剩余字符无法满足数量要求
            if (left + right > s.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (left > 0 && s.charAt(i) == '(') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, ans);
            }
            // 尝试去掉一个右括号
            if (right > 0 && s.charAt(i) == ')') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, ans);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    @Test
    public void removeInvalidParenthesesTest() {
        String str = "()())()";
        System.out.println(removeInvalidParentheses(str));
    }

}
