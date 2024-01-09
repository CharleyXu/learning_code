package com.xu.algorithm.linkedlist.reverse;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2023/12/6
 * <p>
 * 25. K 个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * <p>
 * 输出：[2,1,4,3,5]
 */
public class ReverseKGroup {

    /**
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //定义一个伪节点，用来返回结果
        ListNode dummy = new ListNode(0, head);
        // 定义pre和cur节点
        ListNode pre = dummy;
        ListNode cur = dummy;
        // 只到尾节点
        while (cur.next != null) {
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            //不足k时
            if (cur == null) {
                break;
            }
            // 反转链表的头部
            ListNode start = pre.next;
            // 反转链表尾部 指向的节点
            ListNode next = cur.next;
            // 断开要反转的链表
            cur.next = null;
            // 反转后，连接头节点
            pre.next = reverse(start);
            // 连接尾节点，与不反转链表节点的连接
            start.next = next;
            // pre
            pre = start;
            //
            cur = pre;
        }
        return dummy.next;
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
