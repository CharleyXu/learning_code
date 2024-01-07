package com.xu.algorithm.stack.monotone;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 85 最大矩形
 * <p>
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        //对于每个位置，找到以其为矩形右下角的最大矩形
        //对于当前位置(i,j)，横向向左找到连续1的最大长度，然后纵向向上对于每个位置(k,j)都横向向左找到最长的连续1，其中k<i
        //每个位置向左连续1的最大长度可以用一个矩阵h维护
        //进一步，这道题跟84题类似，可以提前将每个位置左侧连续1的最大长度都计算出来，这样对于每一列就可以采用84题一样的方法
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[m];
        int ans = 0;
        int[] a = new int[m], b = new int[m];
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            Arrays.fill(a, -1);
            Arrays.fill(b, m);
            for (int i = 0; i < m; i++) {    //对于每一列，先计算左侧连续1的最大长度，然后使用单调栈
                if (matrix[i][j] == '1') {
                    h[i] = j == 0 ? 1 : h[i] + 1;
                } else {
                    h[i] = 0;
                }
                while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                    b[stack.pop()] = i;
                }
                if (!stack.isEmpty()) {
                    a[i] = stack.peek();
                }
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                ans = Math.max(ans, h[i] * (b[i] - a[i] - 1));
            }
        }
        return ans;
    }

    public int maximalRectangleDp(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] matrix1 = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') {
                matrix1[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    matrix1[i][j] = matrix1[i - 1][j] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix1[i][j] * m <= ans) continue;
                if (matrix1[i][j] != 0) {
                    int cnt = 1;
                    for (int k = j + 1; k < m; k++) {
                        if (matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    ans = Math.max(ans, cnt * matrix1[i][j]);
                }
            }
        }
        return ans;
    }

}
