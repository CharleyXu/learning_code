package com.xu.algorithm.linkedlist;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * @author charlie Created on 2017/12/19.
 */
public class LinkedListTest extends BaseLinkedList {

    /**
     * 从尾结点插入数据
     */
    @Test
    public void addNodeTest() {
        System.out.println("Before:" + head);
        addNode(head, 100);
        System.out.println("插入后的数据当前列表:" + head);
    }

    /**
     * 从指定位置插入数据
     */
    @Test
    public void insertNodeByIndexTest() {
        System.out.println("Before:" + head);
        try {
            insertNodeByIndex(head, 3, 55);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After:" + head);
    }

    /**
     * 从首结点插入数据
     */
    @Test
    public void insertNodeAtFirstTest() {
        System.out.println("Before:" + head);
        try {
            insertNodeAtFirst(head, 55);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After:" + head);
    }

    /**
     * 删除第index个节点
     */
    @Test
    public void deleteIndexTest() {
        try {
            System.out.println("Before:" + head);
            deleteIndex(head, 4);
            System.out.println("After:" + head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除某个节点
     */
    @Test
    public void deleteNodeTest() {
        System.out.println("Before:" + head);
        deleteNode(head, node2);
        System.out.println("删除某个节点后:" + head);
    }

    /**
     * 删除单链表中的重复节点，重复节点只保留一个
     */
    @Test
    public void deleteDuplicationTest() {
        System.out.println("Before:" + head);
        Stopwatch started = Stopwatch.createStarted();
        deleteDuplication(head);
        System.out.println("use " + started.elapsed(TimeUnit.MILLISECONDS) + " ms");
        System.out.println("After:" + head);
    }

    /**
     * 打印链表
     */
    @Test
    public void printTest() {
        print(head);
        System.out.println();
        printReverse(head);
    }

    /**
     * 链表长度
     */
    @Test
    public void sizeTest() {
        ListNode node1 = new ListNode(1, null);
        ListNode head = new ListNode(0, node1);
        int size = size(head);
        System.out.println("链表长度:" + size);
    }

    /**
     * 从尾部插入一条数据
     */
    public void addNode(ListNode head, int val) {
        if (head == null) {
            return;
        }
        ListNode listNode = new ListNode(val, null);
        while (head.next != null) {
            head = head.next;
        }
        head.next = listNode;
    }

    /**
     * 向链表的指定位置插入数据
     */
    public void insertNodeByIndex(ListNode head, int index, int val) throws Exception {
        if (head == null) {
            throw new Exception("head == null错误");
        }
        if (index < 0 || index > size(head)) {
            throw new Exception("index错误");
        }
        //空链表
        if (index == 0 && head.next == null) {
            head.next = new ListNode(val, head.next);
        }
        ListNode pre = head;
        ListNode current = head.next;
        int num = 1;
        while (current != null) {
            if (index == num) {
                pre.next = new ListNode(val, current);
            }
            pre = current;
            current = current.next;
            num++;
        }
    }

    /**
     * 向链表的指定位置插入数据
     */
    public void insertNodeAtFirst(ListNode head, int val) throws Exception {
        if (head == null) {
            throw new Exception("头结点为Null错误");
        }
        head.next = new ListNode(val, head.next);
    }

    /**
     * 删除第index个节点 	使用快慢双指针
     * <p>
     * 一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点
     */
    public void deleteIndex(ListNode head, int index) throws Exception {
        //Null 或 空链表
        if (head == null || head.next == null) {
            throw new Exception("头结点为空 或者是空链表");
        }
        if (index < 1 || index > size(head)) {
            throw new Exception("输入的index错误");
        }
        int i = 1;
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (i == index) {
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
            i++;
        }
    }

    /**
     * 删除某节点
     *
     * @param head 头指针
     * @param node 节点指针
     */
    public void deleteNode(ListNode head, ListNode node) {
        //Null 或 空链表
        if (head == null || head.next == null || node == null) {
            return;
        }
        //尾节点
        if (node.next == null) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        } else {
            //中间节点
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    /**
     * 删除单链表中的重复节点,保留一个
     */
    public void deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = head;
        while (pre != null) {
            ListNode current = pre.next;
            while (current != null) {
                if (pre.val == current.val) {
                    pre.next = current.next;
                }
                current = current.next;
            }
            pre = pre.next;
        }
    }

    /**
     * 获取链表长度
     */
    public int size(ListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    /**
     * 倒序遍历打印 	使用栈结构
     */
    public void printReverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + ",");
        }
    }

    /**
     * 遍历打印链表
     */
    public void print(ListNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

}
