package com.xu.algorithm.structure.queue;

import com.xu.algorithm.structure.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2023/11/23
 * <p>
 * 将链表的“头节点”和“尾节点”分别视为“队首”和“队尾”，
 * <p>
 * 规定队尾仅可添加节点，队首仅可删除节点
 */
public class LinkedListQueue {

    private ListNode head, tail; // 头节点 head ，尾节点 tail

    private int queSize = 0;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入队 ，队尾添加节点*/
    public void push(int num) {
        ListNode node = new ListNode(num);
        // 如果队列为空，则令头、尾节点都指向该节点
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            // 不为空
            tail.next = node;
            tail = node;
        }
        queSize++;
    }

    /* 访问队首元素*/
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }

    /* 出队，队首删除节点*/
    public int pop() {
        int num = peek();
        head = head.next;
        queSize--;
        return num;
    }

}
