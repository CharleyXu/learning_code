package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/8
 * <p>
 * 22 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * <p>
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {

    /**
     * 回溯法
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur,
                           int start, int end, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (start < max) {
            cur.append('(');
            backtrack(ans, cur, start + 1, end, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (end < start) {
            cur.append(')');
            backtrack(ans, cur, start, end + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
