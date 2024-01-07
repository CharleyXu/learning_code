package com.xu.algorithm.array;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/18.
 *
 * 区间子数组个数
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 *
 * 输入: A = [2, 1, 4, 3]
 *
 * L = 2
 *
 * R = 3
 *
 * 输出: 3
 *
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 *
 * 注意:
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 *
 * 数组 A 的长度范围在[1, 50000]。
 */
public class SubArrayBoundedNum {

  /**
   * 滑动窗口 双指针 时间复杂度：O(n), 空间复杂度：O(1)
   */
  public int subArrayBoundedNum(int[] arr, int L, int R) {
    if (arr == null || arr.length < 2) {
      return 0;
    }
    int result = 0, left = -1, right = -1;
    for (int i = 0; i < arr.length; i++) {
      //大于R，重置起点
      if (arr[i] > R) {
        left = i;
        right = i;
        continue;
      }
      //找到大于的区间
      if (arr[i] >= L) {
        right = i;
      }
      System.out.println(left + "," + right);
      result += (right - left);
    }
    return result;
  }

  @Test
  public void subArrayBoundedNumTest() {
    int[] arr = new int[]{2, 1, 4, 1, 3};
    int i = subArrayBoundedNum(arr, 2, 3);
    System.out.println(i);
    int result = numSubarrayBoundedMax(arr, 2, 3);
    System.out.println(result);
  }

  /**
   * 暴力破解 时间复杂度：O(n^2), 空间复杂度：O(1)
   */
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int res = 0;
    for (int i = 0; i < A.length; i++) {
      boolean flag = false;
      for (int j = i; j < A.length; j++) {
        if (A[j] > R) {
          break;
        } else if (A[j] < L) {
          if (flag) {
            res++;
          }
        } else {
          res++;
          flag = true;
        }
      }
    }
    return res;
  }
}
