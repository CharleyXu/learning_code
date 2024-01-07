package com.xu.algorithm.linkedlist.find;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 查找链表的倒数第n个结点
 */
public class FindNthFromEnd extends BaseLinkedList {

    /**
     * 快慢指针
     */
    public ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 0  1 7 8 9 9 15
     */
    @Test
    public void findNthFromEndTest() {
        ListNode lastNode = findNthFromEnd(head, 5);
        System.out.println(lastNode);
    }

}
