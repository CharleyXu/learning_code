package com.xu.algorithm.linkedlist.delete;

import com.xu.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharleyXu on 2020-06-02
 * <p>
 * 移除重复结点
 */
public class RemoveDuplicateNodes {

    /**
     * 双指针 + set集合
     * <p>
     * 集合依次存储节点的数值，并依次比较，
     * <p>
     * 如果重复的值出现，直接直接把该重复的值的节点的前一个节点指向该节点的下一个节点
     * <p>
     * 注意，本题的哨兵节点与当前节点是不断变化的，二者为一前一后关系
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = curr;
        Set<Integer> sets = new HashSet<>();
        while (curr != null) {
            if (sets.contains(curr.val)) {
                dummy.next = curr.next;
            } else {
                sets.add(curr.val);
                dummy = curr;
            }
            curr = curr.next;
        }
        return head;
    }

}
