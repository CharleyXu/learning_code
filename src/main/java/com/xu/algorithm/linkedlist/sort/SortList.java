package com.xu.algorithm.linkedlist.sort;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2023/12/8
 * <p>
 * 148 排序链表
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 归并
        // 快慢指针，找到中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 存储中间节点的下一个节点
        ListNode temp = slow.next;
        // 从中间节点断开
        slow.next = null;
        // 返回排序后的头节点
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        // 返回合并后的头节点
        return mergeListNode(left, right);
    }

    // 合并两个有序数组
    private ListNode mergeListNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    public ListNode bubbleSort(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        int temp = 0;
        ListNode cur;
        while (pre.next != null) {
            cur = pre.next;
            while (cur != null) {
                if (cur.val < pre.val) {
                    temp = cur.val;
                    cur.val = pre.val;
                    pre.val = temp;
                }
                cur = cur.next;
            }
            pre = pre.next;
        }
        return head;
    }

}
