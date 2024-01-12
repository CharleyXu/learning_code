package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2024/1/9
 * <p>
 * 88 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置
 */
public class Partition {

    /**
     * 时间复杂度 O(n)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode sHead = small;
        ListNode large = new ListNode(-1);
        ListNode lHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = lHead.next;
        return sHead.next;
    }
}
