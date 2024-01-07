package com.xu.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/2/15.
 * <p>
 * 实现一个下压堆栈(链表实现) LIFO
 */
public class Stack<T> {

    Node first;//栈顶
    int N;

    /**
     * 栈顶添加元素
     * <p>
     * push(e) pop() peek()
     */
    public void push(T data) {
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
        N++;
    }

    /**
     * 查看栈顶元素，为空时返回null
     */
    public T peek() {
        if (first == null) {
            return null;
        }
        return first.data;
    }

    //栈顶删除元素
    public T pop() {
        if (first == null) {
            return null;
        }
        T data = first.data;
        first = first.next;
        N--;
        return data;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

    /**
     * 栈   FILO
     * <p>
     * push(e) pop() peek()
     * <p>
     * addFirst(e) removeFirst() peekFirst()
     */
    @Test
    public void dequeStackTest() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(50);
        deque.push(30);
        deque.push(20);
        System.out.println(deque.pop());
        System.out.println(deque.peek());
    }

    private class Node {

        T data;

        Node next;
    }

}
