package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
 * 删除链表中等于给定值 val 的所有节点
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
