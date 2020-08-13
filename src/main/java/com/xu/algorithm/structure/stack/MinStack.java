package com.xu.algorithm.structure.stack;

/**
 * @author CharleyXu Created on 2019/3/21.
 *
 * 实现最小栈
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
