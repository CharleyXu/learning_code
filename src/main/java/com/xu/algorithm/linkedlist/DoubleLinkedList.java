package com.xu.algorithm.linkedlist;

/**
 * Created by CharleyXu on 2024/7/18
 * <p>
 * 实现双向链表
 */
public class DoubleLinkedList<T> {

    public static class Node<T> {

        // 存储数据
        public T data;

        // 指向前一个节点
        public Node<T> pre;

        // 指向下一个节点
        public Node<T> next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

    }

    // 头节点
    private Node<T> head;

    // 节点数量
    private int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 插入节点到链表尾部
    public void addLast(Node<T> node) {
        if (isEmpty()) {
            head = node;
            size++;
        } else {
            Node<T> temp = head;
            // 找到最后一个节点
            while (temp.next != null) {
                temp = temp.next;
            }
            addNode(temp, node);
        }
    }

    // 将新节点插入到指定节点
    public void addNode(Node<T> preNode, Node<T> curNode) {
        if (preNode.next != null) {
            preNode.next.pre = curNode;
        }
        curNode.next = preNode.next;
        curNode.pre = preNode;
        preNode.next = curNode;
        size++;
    }

    /**
     * 删除指定位置的节点
     */
    public void deleteNode(int k) {
        Node<T> node = findNode(k);
        node.next.pre = node.pre;
        if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
        }
    }

    /**
     * 找到第k个节点
     */
    public Node<T> findNode(int k) {
        if (k > size || k < 0) {
            throw new RuntimeException("k必须在0-size之间");
        }
        int cnt = 0;
        Node<T> cur = head;
        while (cnt < k) {
            cnt++;
            cur = cur.next;
        }
        return cur;
    }

}
