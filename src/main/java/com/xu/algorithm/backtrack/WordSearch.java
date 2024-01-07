package com.xu.algorithm.backtrack;

/**
 * Created by CharleyXu on 2024/1/3
 * <p>
 * 79 单词搜索
 * <p>
 * 给定一个字母矩阵，所有的字母都与上下左右四个方向上的字母相连。
 * <p>
 * 给定一个字符串，求 字符串能不能在字母矩阵中寻找到
 * <p>
 * 输入是一个二维字符数组和一个字符串，输出是一个布尔值，表示字符串是否可以被寻找到。
 * <p>
 * Input: word = "ABCCED",
 * <p>
 * board =
 * <p>
 * [[’A’,’B’,’C’,’E’],
 * <p>
 * [’S’,’F’,’C’,’S’],
 * <p>
 * [’A’,’D’,’E’,’E’]]
 * <p>
 * Output: true
 */
public class WordSearch {

    /**
     * 时间复杂度 O(m * n * 3的k次方)
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        // 遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        // 边界检查
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        // 当前字符匹配，标记已经访问
        char temp = board[row][col];
        board[row][col] = '#';
        // 如果已经找到完整的单词，返回true
        if (index == word.length() - 1) {
            return true;
        }
        // 检测当前字符的上下左右四个方向
        boolean result = dfs(board, row - 1, col, word, index + 1) || dfs(board, row + 1, col, word, index + 1)
                || dfs(board, row, col - 1, word, index + 1) || dfs(board, row, col + 1, word, index + 1);
        // 回退： 撤销选择，恢复到之前的状态
        board[row][col] = temp;
        return result;
    }

}
