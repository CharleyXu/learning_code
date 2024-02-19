package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
 * 删除链表中等于给定值 val 的所有节点
 */
public class RemoveElements {

    /**
     * 203. 移除链表元素
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    /**
     * 237. 删除链表中的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 2487 从链表中移除节点
     * <p>
     * 给你一个链表的头节点 head 。
     * <p>
     * 移除每个右侧有一个更大数值的节点。
     * <p>
     * 返回修改后链表的头节点 head
     * <p>
     * 输入：head = [5,2,13,3,8]
     * <p>
     * 输出：[13,8]
     */
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
}
