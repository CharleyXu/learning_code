package com.xu.algorithm.linkedlist.print;

import com.xu.algorithm.linkedlist.BaseLinkedList;
import com.xu.algorithm.linkedlist.ListNode;
import com.xu.algorithm.stack.Stack;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 反向打印链表
 */
public class PrintReverseLinkedList extends BaseLinkedList {

    public void printReverseLinked(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        if (listNode != null) {
            stack.push(listNode.val);
        }
        while (listNode.next != null) {
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void printReverseLinkedTest() {
        printReverseLinked(head);
    }
}
