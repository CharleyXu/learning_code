package com.xu.algorithm.linkedlist.reverse;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
 * 92 反转链表II
 */
public class ReverseBetween extends BaseLinkedList {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
     * <p>
     * 1 ≤ m ≤ n ≤ 链表长度
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(1, head);
        ListNode pre = dummy;
        // 遍历至m的前一个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode prev = null;
        // 翻转
        for (int i = m; i <= n; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // 修改 m 和 n-m 位置处的节点指向
        pre.next.next = curr;
        pre.next = prev;
        return dummy.next;
    }

    /**
     * 0-1-7-8-9-9-15
     */
    @Test
    public void reversePartlyTest() {
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }

}
