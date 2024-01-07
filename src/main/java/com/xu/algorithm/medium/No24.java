package com.xu.algorithm.medium;

import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/28.
 * <p>
 * Swap Nodes in Pairs	交换对中的节点
 * <p>
 * 给定一个链表，交换每两个相邻节点并返回其头部。 例如， 给定1-> 2-> 3-> 4，您应该返回列表2-> 1-> 4-> 3
 * <p>
 * 你的算法应该只使用恒定的空间。您不能修改列表中的值，只有节点本身可以更改。
 */
public class No24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //指向原指针Head
        ListNode h = new ListNode(0);
        h.next = head;
        //pre 指向需要交换的pair的前面一个Node		p1 指向需要交换的pair的第一个Node
        ListNode pre = h, p1 = head, p2 = head.next;
        while (p1 != null && p2 != null) {
            // swap
            pre.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            // 指针后移
            pre = p1;
            p1 = p1.next;
            if (p1 != null) {
                p2 = p1.next;
            }
        }
        return h.next;
    }

    @Test
    public void test() {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(head);
        ListNode listNode = swapPairs(head);
        System.out.println(listNode);
    }

}
