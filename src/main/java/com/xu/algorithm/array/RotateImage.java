package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 48. Rotate Image (Medium) 旋转图像
 * <p>
 * 给定一个 n × n 的矩阵，求它顺时针旋转 90 度的结果
 * <p>
 * Input:
 * [[1,2,3],
 * <p>
 * [4,5,6],
 * <p>
 * [7,8,9]]
 * Output:
 * <p>
 * [[7,4,1],
 * <p>
 * [8,5,2],
 * <p>
 * [9,6,3]]
 */
public class RotateImage {

    /**
     * 对于矩阵中第 i 行的第 j 个元素，
     * <p>
     * 在旋转后，它出现在倒数第 i 列的第 j 个位置。
     * <p>
     * matrix_new[j][n - i - 1] = matrix[i][j];
     *
     * matrix[row][col]=matrix[n−col−1][row]
     * <p>
     * 原地旋转
     */
    public void rotate(int[][] matrix) {
        int temp;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * 使用辅助矩阵
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

}
