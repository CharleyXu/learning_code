package com.xu.algorithm.linkedlist.merge;

import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2023/11/29
 * <p>
 * 23. Merge k Sorted Lists
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 时间复杂度: O(kn×logk)
     * 空间复杂度: 递归会使用到 O(logk) 空间代价的栈空间
     */
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度。
     * <p>
     * 因为每次循环迭代中，a 和 b 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。
     * <p>
     * 空间复杂度：O(1)O(1) 。我们只需要常数的空间存放若干变量。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
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
        curr.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }

    /**
     * 使用小根堆对 1 进行优化，每次 O(logK) 比较 K个指针求 min, 时间复杂度：O(NlogK)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        // 创建最小堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        // 创建虚拟节点
        ListNode dummy = new ListNode();
        // 尾节点
        ListNode tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;
            // 如果链表不为空，重新添加到堆中
            if (tail.next != null) {
                priorityQueue.add(tail.next);
            }
        }
        return dummy.next;
    }

    @Test
    public void mergeKListsTest() {
//        ListNode listNode = mergeKLists(new ListNode[]{node1, node4, node7});
//        System.out.println(listNode);
        ListNode listNode2 = mergeKLists2(new ListNode[]{node1, node4, node7});
        System.out.println(listNode2);
    }

    ListNode node8 = new ListNode(6, null);
    ListNode node7 = new ListNode(2, node8);

    ListNode node6 = new ListNode(4, null);
    ListNode node5 = new ListNode(3, node6);
    ListNode node4 = new ListNode(1, node5);

    ListNode node3 = new ListNode(5, null);
    ListNode node2 = new ListNode(4, node3);
    ListNode node1 = new ListNode(1, node2);

}
