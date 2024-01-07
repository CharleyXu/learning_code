package com.xu.algorithm.binary;

/**
 * Created by CharleyXu on 2024/1/4
 * <p>
 * 240 搜索二维矩阵
 * <p>
 * 每行的元素从左到右升序排列。
 * <p>
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrixII {

    /**
     * 从右上角开始查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


}
