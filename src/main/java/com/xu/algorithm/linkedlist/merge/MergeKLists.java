package com.xu.algorithm.linkedlist.merge;

import com.xu.algorithm.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2023/11/29
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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                curr.next = aPtr;
                aPtr = aPtr.next;
            } else {
                curr.next = bPtr;
                bPtr = bPtr.next;
            }
            curr = curr.next;
        }
        curr.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    /**
     * 使用优先级队列
     */
    static class Status {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>((v1, v2) -> v1.val - v2.val);

    public ListNode mergeKLists2(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }


}
