package com.xu.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author CharleyXu Created on 2019/3/19.
 * <p>
 * leetcode 27
 */
public class RemoveElement {

    /**
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
    public void removeElementTest() {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int i = removeElement(arr, val);
        System.out.println(Arrays.toString(arr));
        System.out.println(i);
    }

}
