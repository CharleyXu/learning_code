package com.xu.algorithm.linkedlist.sort;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 147 对链表进行插入排序
 * <p>
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头
 */
public class InsertionSortList extends BaseLinkedList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // dummy节点
        ListNode dummy = new ListNode(-1, head);
        // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode lastSorted = head;
        // cur节点
        ListNode cur = head.next;
        // 插入排序
        while (cur != null) {
            // cur 应该在 lastSorted之后
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                // 从链表头开始遍历 prev是插入节点curr位置的前一个节点
                ListNode pre = dummy;
                // 循环退出的条件是找到curr应该插入的位置
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                // 对cur的插入
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            // cur为下一个待插入的元素
            cur = lastSorted.next;
        }
        return dummy.next;
    }

    @Test
    public void insertionSortListTest() {
        // 0, 1, 7, 8, 9, 9, 15
        // 0, 1, 7, 8, 9, 9, 15
        System.out.println(insertionSortList(head));
    }

}
