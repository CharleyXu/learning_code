package com.xu.algorithm.linkedlist.sort;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/18
 * <p>
 * 143 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class ReorderList extends BaseLinkedList {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * 第一步，将链表平均分成两半
     * 1 -> 2 -> 3
     * 4 -> 5 -> 6
     * <p>
     * 第二步，将第二个链表逆序
     * 1 -> 2 -> 3
     * 6 -> 5 -> 4
     * <p>
     * 第三步，依次连接两个链表
     * 1 -> 6 -> 2 -> 5 -> 3 -> 4
     * <p>
     * 寻找中间节点 + 链表逆序 + 合并链表
     * <p>
     * 时间复杂度 O(N)
     * <p>
     * 空间复杂度 O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // cur 指向右半部分链表
        ListNode cur = slow.next;
        // 断掉链表，作为左半部分链表
        slow.next = null;
        //
        // 翻转右半部分链表， pre 为右半部分链表头节点
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            // 移动指针
            pre = cur;
            cur = temp;
        }
        cur = head;
        // 此时 cur, pre 分别指向链表左右两半的第一个节点，链表依次连接
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            // 移动指针
            cur = pre.next;
            pre = temp;
        }
    }

    /**
     * 使用线性表
     * <p>
     * 时间复杂度 O(N)
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    @Test
    public void reorderListTest() {
        // 0, 1,  7, 8, 9, 9, 15
        // 0, 15, 1, 9, 7, 9, 8
        reorderList(head);
        System.out.println(head);
    }

}
