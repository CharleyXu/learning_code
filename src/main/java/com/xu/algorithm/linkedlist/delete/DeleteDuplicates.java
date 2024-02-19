package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
 * 82. 删除排序链表中的重复元素
 *
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，
 * <p>
 * 只保留原始链表中 没有重复出现的数字。
 */
public class DeleteDuplicates {

    /**
     * 82. 删除排序链表中的重复元素
     *
     * <p>
     * 给定一个排序链表，删除所有含有重复数字的节点，
     * <p>
     * 只保留原始链表中 没有重复出现的数字。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    /**
     * 83 删除排序链表中的重复元素, 使每个元素只出现一次
     */
    public ListNode deleteDuplicateNodes(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
