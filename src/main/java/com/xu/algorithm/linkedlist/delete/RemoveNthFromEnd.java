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

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) {
            return head.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 0  1 7 8 9 9 15
     */
    @Test
    public void removeNthFromEndTest() {
        ListNode listNode = removeNthFromEnd(head, 4);
        System.out.println(listNode);
    }
}
