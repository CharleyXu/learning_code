package com.xu.algorithm.linkedlist.ring;

import com.xu.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2020-06-04
 * <p>
 * 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * Floyd 算法
     * <p>
     * 通过数学推导得到
     * <p>
     * 环外链表的长度 = 第一次相遇点 + n-1次环的长度
     * <p>
     * 先找出相交点
     * <p>
     * 所以只需要将其中一个指针移动到链表头部，另一个指针保持在第一次相遇位置，
     * <p>
     * 两个指针同时出发，且行进速度为一个节点，再次相遇点则为环的入口
     */
    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

}
