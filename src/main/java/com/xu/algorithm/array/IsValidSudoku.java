package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 36 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * <p>
 * 1，数字 1-9 在每一行只能出现一次。
 * <p>
 * 2，数字 1-9 在每一列只能出现一次。
 * <p>
 * 3，数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 输入：board =
 * <p>
 * <p>
 * [["5","3",".",".","7",".",".",".","."]
 * <p>
 * ,["6",".",".","1","9","5",".",".","."]
 * <p>
 * ,[".","9","8",".",".",".",".","6","."]
 * <p>
 * ,["8",".",".",".","6",".",".",".","3"]
 * <p>
 * ,["4",".",".","8",".","3",".",".","1"]
 * <p>
 * ,["7",".",".",".","2",".",".",".","6"]
 * <p>
 * ,[".","6",".",".",".",".","2","8","."]
 * <p>
 * ,[".",".",".","4","1","9",".",".","5"]
 * <p>
 * ,[".",".",".",".","8",".",".","7","9"]]
 * <p>
 * 输出：true
 */
public class IsValidSudoku {

    /**
     * 复杂度为 O(1)
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int u = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row[i][u] || col[j][u] || area[idx][u]) {
                    return false;
                }
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        return true;
    }


}
