package com.xu.algorithm.stack;

import com.xu.algorithm.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2023/11/23
 * <p>
 * 使用链表来实现栈时，我们可以将链表的头节点视为栈顶，尾节点视为栈底。
 * 对于入栈操作，我们只需将元素插入链表头部，这种节点插入方法被称为“头插法”。
 * <p>
 * 而对于 出栈操作，只需将头节点从链表中删除即可
 */
public class LinkedListStack {

    private ListNode stackPeek; // 将头节点作为栈顶 private int stkSize = 0; // 栈的长度

    private int stkSize = 0; // 栈的长度

    public LinkedListStack() {
        stackPeek = null;
    }

    /* 获取栈的长度 */
    public int size() {
        return stkSize;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入栈 */
    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stkSize++;
    }

    /* 访问栈顶元素 */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    /* 出栈 */
    public int pop() {
        int peek = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return peek;
    }

}
