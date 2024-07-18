package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author CharleyXu Created on 2019/3/17
 * <p>
 * 26. 删除数组中的重复项
 */
public class RemoveDuplicates {

    /**
     * reserved，非nums[start - 1] 坐过来
     * <p>
     * 26 删除有序数组中的重复项
     * <p>
     * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * <p>
     * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数
     */
    private int removeDuplicates(int[] nums) {
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start - 1]) {
                nums[start++] = nums[i];
            }
        }
        return start;

    }

    /**
     * 27 移除元素
     * <p>
     * 返回移除后数组的新长度
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
     */
    public int removeElement(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0, index = 0;
        while (i < arr.length) {
            if (arr[i] != val) {
                arr[index++] = arr[i++];
            } else {
                i++;
            }
        }
        return index;
    }

    @Test
    public void removeDuplicatesTest() {
        int[] arr = new int[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int[] ints = Arrays.copyOf(arr, arr.length);
        int num = removeDuplicates(arr);
        System.out.println(num);
        int result = removeElement(ints, 5);
        System.out.println(result);
    }

    /**
     * 80. 删除有序数组中的重复项 II
     * <p>
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
     */
    public int removeDuplicates2(int[] nums) {
        int start = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[start - 2]) {
                nums[start++] = nums[i];
            }
        }
        return start;
    }

    /**
     * 1047 删除字符串中的所有相邻重复项
     * <p>
     * 输入:"abbaca"
     * <p>
     * 输出:"ca"
     */
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> d = new ArrayDeque<>();
        for (char c : cs) {
            if (!d.isEmpty() && d.peekLast().equals(c)) {
                d.pollLast();
            } else {
                d.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            sb.append(d.pollLast());
        }
        return sb.reverse().toString();
    }

}
