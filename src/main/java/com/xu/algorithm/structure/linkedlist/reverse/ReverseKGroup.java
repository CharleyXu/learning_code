package com.xu.algorithm.structure.linkedlist.reverse;

import com.xu.algorithm.structure.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2023/12/6
 * <p>
 * 25. K 个一组翻转链表
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
