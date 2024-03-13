package com.xu.algorithm.linkedlist.ring;

import com.xu.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2020-06-04
 * <p>
 * 链表是否有环
 */
public class HasCycle {

    /**
     * 141. 环形链表
     * <p>
     * java双指针 fast一次走两个，slow走一个，当两个相遇则有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 额外存储
     * <p>
     * 时间复杂度：O(n)
     * <p>
     * 空间复杂度：使用了额外的存储空间，所以空间复杂度为O(n)
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

}
