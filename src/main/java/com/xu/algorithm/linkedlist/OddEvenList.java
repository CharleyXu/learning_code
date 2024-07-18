package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2024/1/19
 * <p>
 * 328 奇偶链表
 * <p>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数
 *
 * 输入: head = [1,2,3,4,5]
 *
 * 输出: [1,3,5,2,4]
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
