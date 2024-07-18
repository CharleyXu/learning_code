package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2020-06-16
 * <p>
 * 2. 两数相加
 */
public class AddTwoNumbers {

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * <p>
     * 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m, n) 次
     * <p>
     * 空间复杂度：O(max(m, n))，新列表的长度最多为 max(m,n)+1
     * <p>
     * 使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
