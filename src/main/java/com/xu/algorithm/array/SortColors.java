package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 77 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * <p>
 * 输出：[0,0,1,1,2,2]
 */
public class SortColors {

    /**
     * 刷油漆算法
     * <p>
     * 把当前值交换到n0和n1的位置上
     */
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[n1++] = 1;
            }
            if (num < 1) {
                nums[n0++] = 0;
            }
        }
    }

    /**
     * 单指针，
     * <p>
     * 第一次遍历，将0交换到头部，第二次遍历，将1交换到头部之后
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }

    /**
     * 双指针
     */
    public void sortColors3(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void sortColorTest() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        int[] clone = nums.clone();
        sortColors2(clone);
        System.out.println(Arrays.toString(clone));
        int[] clone3 = nums.clone();
        sortColors3(clone3);
        System.out.println(Arrays.toString(clone3));
    }

}
