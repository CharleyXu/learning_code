package com.xu.algorithm.linkedlist.find;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 寻找中间节点
 */
public class FindMidNode extends BaseLinkedList {

    /**
     * 快慢指针，步长为2
     */
    public ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 两个链表的第一个公共节点
     *
     * 两个无环的单向链表，找出它们的第一个公共结点
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode a = pHead1, b = pHead2;
        while (a != b) {
            a = a != null ? a.next : pHead2;
            b = b != null ? b.next : pHead1;
        }
        return a;
    }

    /**
     * 0  1 7 8 9 9 15
     */
    @Test
    public void findMidNode() {
        ListNode midNode = findMidNode(head);
        System.out.println(midNode);
    }

}
