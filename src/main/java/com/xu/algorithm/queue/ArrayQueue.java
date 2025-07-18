package com.xu.algorithm.queue;

/**
 * Created by CharleyXu on 2023/11/23
 * <p>
 * 基于环形数组实现的队列
 */
public class ArrayQueue {

    private int[] nums; // 用于存储队列元素的数组
    private int head; // 队首指针，指向队首元素
    private int queSize; // 队列长度

    public ArrayQueue(int capacity) {
        nums = new int[capacity];
        head = queSize = 0;
    }

    /* 获取队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入队 */
    public void push(int num) {
        if (queSize == capacity()) {
            System.out.println(" 队列已满");
            return;
        }
        // 计算尾指针，指向队尾索引 + 1
        // 通过取余操作，实现 rear 越过数组尾部后回到头部
        int tail = (head + queSize) % capacity();
        // 将 num 添加至队尾
        nums[tail] = num;
        queSize++;
    }

    public int pop() {
        int num = peek();
        // 队首指针向后移动一位，若越过尾部则返回到数组头部
        head = (head + 1) % capacity();
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return nums[head];
    }

}
