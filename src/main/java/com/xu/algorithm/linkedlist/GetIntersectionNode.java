package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2020-05-29
 * <p>
 * 链表相交
 * <p>
 * 找到两个单链表相交的起始节点
 */
public class GetIntersectionNode {

    /**
     * 思路：双指针法。一个指针指向A链表，一个指向B链表。
     * <p>
     * 如果相遇则返回，否则没有交点
     * <p>
     * 如果存在相交结点，那么pA和pB一定会相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
