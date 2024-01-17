package com.xu.algorithm.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrderMatrix {

    /**
     * 54 螺旋矩阵
     * <p>
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     * <p>
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * <p>
     * 输出：[1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        dfs(matrix, 0, rows - 1, 0, cols == 0 ? 0 : cols - 1, ans);
        return ans;
    }

    private void dfs(int[][] matrix, int mStart, int mEnd, int nStart, int nEnd, List<Integer> ans) {
        if (mStart > mEnd || nStart > nEnd) {
            return;
        }
        for (int i = nStart; i <= nEnd; i++) {
            ans.add(matrix[mStart][i]);
        }
        for (int j = mStart + 1; j <= mEnd; j++) {
            ans.add(matrix[j][nEnd]);
        }
        if (mStart < mEnd && nStart < nEnd) {
            for (int i = nEnd - 1; i >= nStart; i--) {
                ans.add(matrix[mEnd][i]);
            }
            for (int j = mEnd - 1; j > mStart; j--) {
                ans.add(matrix[j][nStart]);
            }
        }
        dfs(matrix, mStart + 1, mEnd - 1, nStart + 1, nEnd - 1, ans);
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                for (int j = bottom - 1; j > top; j--) {
                    ans.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }


    /**
     * 59 螺旋矩阵II
     * <p>
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     * <p>
     * 输入：n = 3
     * <p>
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     */
    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                ans[j][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                for (int j = bottom - 1; j > top; j--) {
                    ans[j][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    @Test
    public void spiralOrderTest() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder2(matrix));
    }

    @Test
    public void generateMatrixTest() {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

}
