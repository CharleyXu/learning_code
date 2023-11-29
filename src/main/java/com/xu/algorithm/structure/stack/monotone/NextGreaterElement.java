package com.xu.algorithm.structure.stack.monotone;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement {

    /**
     * 时间复杂度：O(m+n)，其中 m 是 nums1的长度，n是 nums2的长度。
     *
     * <p>
     * 空间复杂度：O(n)，用于存储哈希表
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
