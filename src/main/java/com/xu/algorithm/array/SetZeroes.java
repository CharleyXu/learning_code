package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/13
 * <p>
 * 73 矩阵置零
 */
public class SetZeroes {

    /**
     * 空间复杂度 O(m+n)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 空间复杂度 O(1)
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        // 第一行是否有零
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < m; i++) {
            if (matrix[m][0] == 0) {
                colFlag = true;
                break;
            }
        }
        // 第一行第一列作为标志位
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void setZeroesTest() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
