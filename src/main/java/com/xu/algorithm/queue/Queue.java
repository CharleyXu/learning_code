package com.xu.algorithm.queue;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/2/15.
 *
 * 实现一个队列 FIFO
 */
public class Queue<T> {

  private class Node {

    T data;
    Node next;
  }

  private Node first;
  private Node last;
  private int N;

  //offer(e) poll()  peek()  不会抛异常
  //add(e) remove() element()   会抛异常

  //入列  enqueue
  public void offer(T data) {
    //链表尾添加元素
    Node oldLast = last;
    last = new Node();
    last.data = data;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  //出列  dequeue
  public T poll() {
    //从表头删除元素
    if (first == null) {
      return null;
    }
    T data = first.data;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    N--;
    return data;
  }

  //获取但是不移除此队列的头
  public T peek() {
    //从表头删除元素
    if (isEmpty()) {
      return null;
    }
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  @Test
  public void queueTest() {
    Queue<Integer> queue = new Queue<>();
    queue.offer(14);
    queue.offer(11);
    queue.offer(7);
    System.out.println(queue.peek());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.isEmpty());
    System.out.println(queue.size());
  }

}
