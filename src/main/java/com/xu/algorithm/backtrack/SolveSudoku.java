package com.xu.algorithm.backtrack;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 37 解数独
 */
public class SolveSudoku {

    /**
     * 回溯
     * <p>
     * 时间复杂度 O（9的 9*9次方）
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], box = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1', idx = i / 3 * 3 + j / 3;
                row[i][num] = col[j][num] = box[idx][num] = true;
            }
        }
        solveSudoku(board, 0, row, col, box);
    }

    boolean solveSudoku(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        // 有解时
        if (n == 81) {
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return solveSudoku(board, n + 1, row, col, box);
        }
        int k = i / 3 * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) {
                continue;
            }
            // 尝试I
            board[i][j] = (char) (num + '1');
            // 尝试
            row[i][num] = col[j][num] = box[k][num] = true;
            // 下一轮选择
            if (solveSudoku(board, n + 1, row, col, box)) return true;
            // 回退，撤销选择，恢复到之前的状态
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        // 回退I
        board[i][j] = '.';
        return false;
    }


}
