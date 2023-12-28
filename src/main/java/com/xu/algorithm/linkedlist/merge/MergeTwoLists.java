package com.xu.algorithm.linkedlist.merge;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-02
 */
public class MergeTwoLists extends BaseLinkedList {

    /**
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度。
     * <p>
     * 因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。
     * <p>
     * 空间复杂度：O(1)O(1) 。我们只需要常数的空间存放若干变量。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return head.next;
    }

    ListNode node3 = new ListNode(62, null);
    ListNode node2 = new ListNode(41, node3);
    ListNode node1 = new ListNode(3, node2);

    @Test
    public void mergeTwoLists() {
        ListNode mergeTwoLists = mergeTwoLists(head, node1);
        System.out.println(mergeTwoLists);
    }

}
