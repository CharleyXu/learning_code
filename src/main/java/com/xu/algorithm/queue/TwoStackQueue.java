package com.xu.algorithm.queue;

import com.xu.algorithm.stack.Stack;

/**
 * Created by CharleyXu on 2023/11/23
 */
public class TwoStackQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public TwoStackQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (inStack.size() > 0) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (inStack.size() > 0) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

}
