package com.xu.algorithm.linkedlist;

import org.junit.Test;

/**
 * Created by CharleyXu on 2024/2/28
 * <p>
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * <p>
 * 输出：[4,5,1,2,3]
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        // 新链表末尾节点位置
        int position = n - k % n;
        if (position == n) {
            return head;
        }
        // 连成环
        cur.next = head;
        while (position-- > 0) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        // 在指定位置断开
        cur.next = null;
        return res;
    }

    @Test
    public void rotateRightTest() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(head);
        ListNode resNode = rotateRight(head, 3);
        System.out.println(resNode);
    }

}
