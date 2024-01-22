package com.xu.algorithm.stack.monotone;

import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 496. 下一个更大元素 I
 * <p>
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * <p>
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2]
 * <p>
 * 输出：[-1,3,-1]
 */
public class NextGreaterElement {

    /**
     * 时间复杂度：O(m+n)，其中 m 是 nums1的长度，n是 nums2的长度。
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

    /**
     * 503 下一个更大元素 II
     * <p>
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
     * <p>
     * 输入: nums = [1,2,1]
     * <p>
     * 输出: [2,-1,2]
     * <p>
     * 单调栈 + 循环数组
     * <p>
     * 把数组拉直，下标取模
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }

    /**
     * 1019 链表中的下一个更大节点
     * <p>
     * 对于列表中的每个节点，查找下一个 更大节点 的值
     * <p>
     * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0
     * <p>
     * 输入：head = [2,7,4,3,5]
     * <p>
     * 输出：[7,0,5,5,0]
     * <p>
     * 时间复杂度 O(N)
     * <p>
     */
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        int[] ans = new int[n];
        // 维护一个单调递减栈（节点值、节点下标）
        Deque<int[]> deque = new ArrayDeque<>();
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!deque.isEmpty() && deque.peek()[0] < cur.val) {
                ans[deque.pop()[1]] = cur.val;
            }
            deque.push(new int[]{cur.val, i++});
        }
        return ans;
    }

    public int[] nextLargerNodes2(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        int[] ans = new int[n];
        // 维护一个单调递减栈
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!deque.isEmpty() && ans[deque.peek()] < cur.val) {
                ans[deque.pop()] = cur.val;
            }
            deque.push(i);
            ans[i++] = cur.val;
        }
        // 在循环结束后，栈中下标对应元素是没有下一个更大元素的，所以要把栈中的下标对应的ans置为 0。
        for (Integer idx : deque) {
            ans[idx] = 0;
        }
        return ans;
    }

    @Test
    public void nextGreaterElementsTest() {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

}
