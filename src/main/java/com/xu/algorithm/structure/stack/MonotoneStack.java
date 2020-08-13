package com.xu.algorithm.structure.stack;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/21.
 * <p>
 * 单调栈
 * <p>
 * 给一个数组，返回一个大小相同的数组。
 * <p>
 * 返回的数组的第i个位置的值应当是，对于原数组中的第i个元素，至少往右走多少步，
 * <p>
 * 才能遇到一个比自己大的元素（如果之后没有比自己大的元素，或者已经是最后一个元素，则在返回数组的对应位置放上-1）。
 * <p>
 * 简单的例子：
 * <p>
 * input: 5,3,1,2,4
 * <p>
 * return: -1 3 1 1 -1
 */
public class MonotoneStack {

    /**
     * 单调栈  时间复杂度O(n)
     * <p>
     * 和前后元素之间的大小关系有关系的话，比如 要找比某个元素大的元素
     * <p>
     * 前后的bar的高低影响了最终矩形的计算
     */
    private int[] findLarger(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 暴力破解 O(2)
     */
    private int[] findLargerO2(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            result[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        result[arr.length - 1] = -1;
        return result;
    }

    /**
     * 通常应用在一维数组上。如果遇到的问题，和前后元素之间的大小关系有关系的话，
     * <p>
     * （例如  要找比某个元素大的元素，
     * <p>
     * 前后的bar的高低影响了最终矩形的计算），我们可以试图用单调栈来解决
     */
    @Test
    public void findLargerTest() {
        int[] arr = new int[]{5, 3, 1, 2, 4};
        int[] larger = findLarger(arr);
        System.out.println(Arrays.toString(larger));
        int[] largerO2 = findLargerO2(arr);
        System.out.println(Arrays.toString(largerO2));
    }
}
