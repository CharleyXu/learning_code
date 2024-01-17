package com.xu.algorithm.stack;

/**
 * @author CharleyXu Created on 2019/3/21.
 * <p>
 * 155
 * <p>
 * 实现最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * <p>
 * int getMin() 获取堆栈中的最小元素
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == pop) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? 0 : minStack.peek();
    }

}
