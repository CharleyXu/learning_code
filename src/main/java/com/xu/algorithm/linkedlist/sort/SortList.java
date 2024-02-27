package com.xu.algorithm.linkedlist.sort;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2023/12/8
 * <p>
 * 148 排序链表
 */
public class SortList extends BaseLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 归并
        // 快慢指针，找到中间节点
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 存储中间节点的下一个节点
        ListNode cur = slow.next;
        // 从中间节点断开
        slow.next = null;
        // 返回排序后的头节点
        ListNode left = sortList(dummy.next);
        ListNode right = sortList(cur);
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

    @Test
    public void sortListTest() {
        System.out.println(sortList(head));
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
