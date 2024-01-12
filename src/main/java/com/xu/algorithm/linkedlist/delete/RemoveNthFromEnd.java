package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 删除倒数第N个节点
 */
public class RemoveNthFromEnd extends BaseLinkedList {

    /**
     * 删除倒数第N个节点
     * <p>
     * 虚拟头结点+快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 使用递归找到倒数第n+1个节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = length(head, n);
        if (length == n) {
            return head.next;
        }
        return head;
    }

    //  获取节点的长度，从后往前数，到第n+1个节点的时候把倒数第n个节点删除。
    private int length(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int len = length(head.next, n) + 1;
        if (len == n + 1) {
            head.next = head.next.next;
        }
        return len;
    }


    /**
     * 0 1 7 8 9 9 15
     */
    @Test
    public void removeNthFromEndTest() {
        System.out.println(removeNthFromEnd(head, 4));
        System.out.println(removeNthFromEnd2(head, 4));
    }
}
