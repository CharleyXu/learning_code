package com.xu.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharleyXu on 2020-08-01
 * <p>
 * hashMap + 双向链表
 */
public class MyLRUCache {

    public MyLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    private Map<Integer, LinkedNode> cache =
            new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        LinkedNode node = cache.get(key);

        if (node == null) {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
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

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
    }

    private void addNode(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private LinkedNode popTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public static void main(String[] args) {
        MyLRUCache map = new MyLRUCache(5);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        System.out.println(map.toString());
        map.put(6, 6);
        map.get(2);
        map.put(7, 7);
        map.get(4);
        System.out.println(map.toString());
    }


}
