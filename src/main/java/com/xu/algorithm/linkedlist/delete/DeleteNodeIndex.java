package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-02
 */
public class DeleteNodeIndex {

    /**
     * 删除第index个节点 	使用快慢双指针
     * <p>
     * 一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点
     */
    public ListNode deleteIndex(ListNode head, int index) {
        // 边界判断
        if (head == null || index < 0) {
            return head;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        // 快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先走index+1步，这样当快指针到达末尾时
        // 慢指针正好指向要删除节点的前一个节点
        for (int i = 0; i <= index && fast != null; i++) {
            fast = fast.next;
        }
        // 如果快指针为null，说明index超出范围
        if (fast == null) {
            return head;
        }
        // 快慢指针同时移动，直到快指针到达末尾
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点：slow.next就是要删除的节点
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点
     */
    public ListNode deleteNodeVar(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 创建虚拟头节点, 统一处理边界情况
        ListNode dummy = new ListNode(0, head);

        ListNode curr = dummy;

        // 查询要删除的节点前驱节点
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }

        // 删除节点（如果找到的话）
        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return dummy.next;

    }

    /**
     * 203. 移除链表元素, 删除所有值为val的节点
     */
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
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
