package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
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
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            // 检查当前节点是否有重复
            if (curr.next != null && curr.val == curr.next.val) {
                int duplicateVal = curr.val;
                // 跳过所有重复的节点
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }
                //连接prev和curr，删除所有重复节点
                prev.next = curr;
            } else {
                // 当前节点无重复，prev向前移动
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    /**
     * 83 删除排序链表中的重复元素, 使每个元素只出现一次
     */
    public ListNode deleteDuplicateNodes(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

}
