package com.xu.algorithm.linkedlist.reverse;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by CharleyXu on 2020-05-29
 * <p>
 * 翻转链表
 */
public class ReverseList extends BaseLinkedList {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 迭代
     * <p>
     * 需要三个指针配合工作，使得两个节点间的指向反向，next指针记录剩下的链表
     * <p>
     * <p>
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     * <p>
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个元素
     * <p>
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素
     * <p>
     * 在更改引用之前，还需要另一个指针来存储下一个节点
     * <p>
     * 最后返回新的头引用
     * <p>
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 0-1-7-8-9-9-15
     */
    @Test
    public void reverseTest() {
        ListNode reverse = reverse(head);
        System.out.println(reverse);
    }
}
