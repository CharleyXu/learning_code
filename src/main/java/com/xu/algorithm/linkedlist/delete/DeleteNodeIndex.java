package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-02
 */
public class DeleteNodeIndex {

    /**
     * 删除第index个节点 	使用快慢双指针
     * <p>
     * 一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点
     */
    public void deleteIndex(ListNode head, int index) throws Exception {
        //Null 或 空链表
        if (head == null || head.next == null) {
            throw new Exception("头结点为空 或者是空链表");
        }
        if (index < 1 || index > size(head)) {
            throw new Exception("输入的index错误");
        }
        int i = 1;
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (i == index) {
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
            i++;
        }
    }

    private int size(ListNode node) {
        int size = 0;
        if (node == null) {
            return size;
        }
        while (node.next != null) {
            node = node.next;
            size++;
        }
        return size;
    }
}
