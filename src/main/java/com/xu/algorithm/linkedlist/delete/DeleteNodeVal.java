package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-02
 * <p>
 * 删除链表的节点
 */
public class DeleteNodeVal {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 头节点
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        while (p.next !=null && p.next.val != val) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
