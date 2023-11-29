package com.xu.algorithm.structure.linkedlist;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/11/29
 */
public class IsPalindromeListNode {

    /**
     * 快慢指针 + 链表翻转
     * <p>
     * [1,2,3,3,2,1]
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 反转
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    @Test
    public void isPalindromeTest() {
        System.out.println(isPalindrome(head));
    }

    ListNode node5 = new ListNode(1, null);
    ListNode node4 = new ListNode(2, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(3, node3);
    ListNode node1 = new ListNode(2, node2);
    protected ListNode head = new ListNode(1, node1);


}
