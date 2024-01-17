package com.xu.algorithm.stack.monotone;

import org.junit.Test;

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

    /**
     * 先求出每层1的高度，以每一点高度为基准，向左向右遍历，计算以这个高度能达到的宽度，求最值
     * <p>
     * 每个点暴力向左找大于等于该数的个数,cnt++，向右找大于等于该数的个数,cnt++，最后的最大值判决
     * <p>
     * Math.max(ans, cnt * matrix1[i][j])
     */
    public int maximalRectangleDp(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] matrix1 = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                matrix1[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    matrix1[i][j] = matrix1[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] * n <= ans) continue;
                if (matrix1[i][j] != 0) {
                    int cnt = 1;
                    for (int k = j + 1; k < n; k++) {
                        if (matrix1[i][k] < matrix1[i][j]) {
                            break;
                        }
                        cnt++;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (matrix1[i][k] < matrix1[i][j]) {
                            break;
                        }
                        cnt++;
                    }
                    ans = Math.max(ans, cnt * matrix1[i][j]);
                }
            }
        }
        return ans;
    }

    @Test
    public void maximalRectangleTest() {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangleDp(matrix));
        System.out.println(maximalRectangle(matrix));
    }

}
