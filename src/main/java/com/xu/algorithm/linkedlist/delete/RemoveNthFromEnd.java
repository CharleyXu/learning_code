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
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先走n+1步，同时检查边界
        for (int i = 0; i <= n; i++) {
            // 如果n大于链表长度，返回原链表
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        // 快慢指针同时移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点（此时可以确保slow.next存在）
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 0 1 7 8 9 9 15
     */
    @Test
    public void removeNthFromEndTest() {
        System.out.println(removeNthFromEnd(head, 4));
    }
}
