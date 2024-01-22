package com.xu.algorithm.linkedlist.merge;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2020-06-02
 */
public class MergeTwoLists extends BaseLinkedList {

    /**
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度。
     * <p>
     * 因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。
     * <p>
     * 空间复杂度：O(1) 。我们只需要常数的空间存放若干变量。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    /**
     * 1669 合并两个链表
     * <p>
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * <p>
     * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置
     * <p>
     * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * <p>
     * 输出：[0,1,2,1000000,1000001,1000002,5]
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1);
        ListNode p1 = list1;
        ListNode p2 = list1;
        int i = 0;
        while (b > 0) {
            b--;
            i++;
            if (i < a) {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        p1.next = list2;
        while (list2 != null && list2.next != null) {
            list2 = list2.next;
        }
        list2.next = p2.next;
        return dummy.next;
    }

    ListNode node3 = new ListNode(62, null);
    ListNode node2 = new ListNode(41, node3);
    ListNode node1 = new ListNode(3, node2);

    @Test
    public void mergeTwoLists() {
        ListNode mergeTwoLists = mergeTwoLists(head, node1);
        System.out.println(mergeTwoLists);
    }

}
