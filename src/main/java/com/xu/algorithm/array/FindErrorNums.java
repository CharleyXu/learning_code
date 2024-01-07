package com.xu.algorithm.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/18.
 *
 * 错误的集合
 *
 * 题干：
 *
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 *
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例1:
 *
 * 输入: nums = [1,2,2,4]
 *
 * 输出: [2,3]
 *
 * 注意:
 *
 * 1、给定数组的长度范围是 [2, 10000]。
 *
 * 2、给定的数组是无序的。
 */
public class FindErrorNums {

  /**
   * 题目分析可得，数组中的值是1-n的整数，
   *
   * 如果没有发生错误的话，且经过排序，则它的值和位置的关系是nums[i] = i + 1，我们可以从这个切入点下手
   *
   * 最容易想的，就是暴力破解，还可以从值与位置的对应关系，发生错误后，值与位置的对应关系就被破环。
   *
   * 时间复杂度：O(n^2),空间复杂度：O(1)
   */
  public int[] findErrorNums(int[] arr) {
    if (arr == null || arr.length < 1) {
      throw new NullPointerException();
    }
    int[] result = new int[2];
    for (int i = 0; i < arr.length; i++) {
      //找出重复值（错误值)
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          result[0] = arr[i];
        }
      }
      boolean flag = false;
      //找出替换值
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == i + 1) {
          flag = true;
        }
      }
      if (!flag) {
        result[1] = i + 1;
      }
    }
    return result;
  }

  /**
   * 空间换时间
   *
   * 时间复杂度O(n),空间复杂度0(n)
   */
  public int[] findErrorNumsUseSpace(int[] arr) {
    int[] result = new int[2];
    int[] countArray = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      countArray[arr[i] - 1]++;
    }
    for (int i = 0; i < countArray.length; i++) {
      if (countArray[i] == 2) {
        result[0] = i + 1;
      }
      if (countArray[i] == 0) {
        result[1] = i + 1;
      }
    }
    return result;
  }

  @Test
  public void findErrorNumsTest() {
    int[] nums = new int[]{1, 2, 2, 4};
    int[] errorNums = findErrorNums(nums);
    System.out.println(Arrays.toString(errorNums));
    int[] errorNumsUseSpace = findErrorNumsUseSpace(nums);
    System.out.println(Arrays.toString(errorNumsUseSpace));
  }
}
