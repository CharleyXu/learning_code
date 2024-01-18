package com.xu.algorithm.binary;

/**
 * Created by CharleyXu on 2024/1/4
 * 74 搜索二维矩阵
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列
 * <p>
 * 每行的第一个整数大于前一行的最后一个整数
 */
public class SearchMatrix {

    /**
     * 两次二分查找
     * <p>
     * 时间复杂度 log(m) + log (n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 第一次二分，定位到所在行
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        //
        int row = r;
        if (matrix[row][0] == target) {
            return true;
        }
        if (matrix[row][0] > target) {
            return false;
        }
        // 第二次二分
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 一次二分查找
     * <p>
     * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
     * <p>
     * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上
     * <p>
     * 时间复杂度 log(mn)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = high + low >> 1;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 240 搜索二维矩阵
     * <p>
     * 每行的元素从左到右升序排列。
     * <p>
     * 每列的元素从上到下升序排列
     * 从右上角开始查找
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
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
