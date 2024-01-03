package com.xu.algorithm.array;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author CharleyXu Created on 2019/3/17
 * <p>
 * 删除数组中的重复项
 */
public class RemoveDuplicates {

    /**
     * reserved，非nums[start - 1] 坐过来
     */
    private int removeDuplicates(int[] nums) {
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start - 1]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;

    }

    /**
     * 双指针
     * <p>
     * start指针，保留有效数组中的位置，"上新"，为未来reserve一个位置
     * <p>
     * i扫描数组，扫旧
     * <p>
     * 满足要求，不等于nums[start - 2]的坐过来，nums[start] = nums[i]
     *
     * <p>
     */
    private int removeDuplicatesTwoElement(int[] nums) {
        int start = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[start - 2]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }

    @Test
    public void removeDuplicatesTest() {
        int[] arr = new int[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int[] ints = Arrays.copyOf(arr, arr.length);
        int num = removeDuplicates(arr);
        System.out.println(num);
        int result = removeDuplicatesTwoElement(ints);
        System.out.println(result);
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
