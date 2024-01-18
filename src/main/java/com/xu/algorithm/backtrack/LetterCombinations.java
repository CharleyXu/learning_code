package com.xu.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 17 电话号码的字母组合
 * <p>
 * 给定一个数字字符串，返回数字可能表示的所有可能的字母组合
 * <p>
 * 数字到字母的映射(电话按键)
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * <p>
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations {

    /**
     * 回溯
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, letters, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, String[] letters, int index, StringBuilder state, List<String> res) {
        if (index == digits.length()) {
            res.add(state.toString());
            return;
        }
        String letter = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            // 尝试： 做出选择，更新状态
            state.append(letter.charAt(i));
            //  进行下一轮选择
            backtrack(digits, letters, index + 1, state, res);
            // 回退： 撤销选择，恢复到之前的状态
            state.deleteCharAt(state.length() - 1);
        }
    }

    @Test
    public void letterCombinationsTest() {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
    }

}
