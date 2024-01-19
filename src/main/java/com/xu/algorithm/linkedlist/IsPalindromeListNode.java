package com.xu.algorithm.linkedlist;

import org.junit.Test;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 234 回文链表
 */
public class IsPalindromeListNode {

    /**
     * 快慢指针 + 链表翻转
     * <p>
     * [1,2,3,3,2,1]
     * <p>
     * 时间复杂度 O(N)，空间复杂度 O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转 后半部分链表
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            // 指针前移
            pre = cur;
            cur = temp;
        }
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = pre;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    // 快慢指针 + 链表翻转
    public boolean isPalindrome2(ListNode head) {
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
//        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
    }

    ListNode node5 = new ListNode(1, null);
    ListNode node4 = new ListNode(2, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(3, node3);
    ListNode node1 = new ListNode(2, node2);
    protected ListNode head = new ListNode(1, node1);


}
