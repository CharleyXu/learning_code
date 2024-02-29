package com.xu.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2020-08-01
 * <p>
 * hashMap + 双向链表
 * <p>
 * 头插法
 */
public class LRUCache {

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        LinkedNode node = cache.get(key);

        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                LinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 新插入的元素或者命中的元素往头部移动，尾部的元素即是最近最少使用
     */
    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private LinkedNode popTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {

        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        LRUCache map = new LRUCache(5);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        System.out.println(map.get(6));
        System.out.println(map.get(1));
        map.put(6, 10);
        map.get(2);
        map.put(7, 7);
        map.get(4);
        System.out.println(map.get(6));
    }


}
