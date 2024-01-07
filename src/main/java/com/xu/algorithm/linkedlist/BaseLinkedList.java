package com.xu.algorithm.linkedlist;

/**
 * @author CharleyXu Created on 2019/3/22.
 */
public class BaseLinkedList {

    ListNode node6 = new ListNode(15, null);
    ListNode node5 = new ListNode(9, node6);
    ListNode node4 = new ListNode(9, node5);
    ListNode node3 = new ListNode(8, node4);
    ListNode node2 = new ListNode(7, node3);
    ListNode node1 = new ListNode(1, node2);
    protected ListNode head = new ListNode(0, node1);

    /**
     * 获取链表长度
     */
    protected int size(ListNode node) {
        if (node == null) {
            return -1;
        }
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
}
