package com.xu.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CharleyXu on 2020-08-13
 * <p>
 * 两个队列实现栈
 * <p>
 * 每次 push 进 Queue1, 都是FIFO的序列，而 pop 时要求实现后进先出，
 * <p>
 * 由于队列只能最先进的从队列头最先弹出，
 * <p>
 * 此时，可以将 Queue1 的元素，全部 pop 出来，通过一个变量 element 来暂存
 * <p>
 * Queue1 中的最后一个元素，在这个过程中，将弹出的元素 push 到 Queue2 (除 Queue1 最后一个元素)，
 * <p>
 * 返回的 element 就是最后 push 到队列的值，相当于栈顶元素，间接实现栈的后进先出特性。
 * <p>
 * 如果此时要继续 pop 出仿真栈的下一个元素，则模仿上一步，
 * <p>
 * 将 Queue2 所有元素，除了最后一个元素都 pop 出来，
 * <p>
 * 并 push 进 Queue1，
 * <p>
 * 这个过程中同样通过 element 这个变量来保存 Queue2 的最后一个元素，返回该元素即栈顶元素。
 * <p>
 * 注意：每次 pop 都最终保证一个 Queue 为空。
 * <p>
 * 如此交替装元素，一个作为发射枪发射子弹，另一个作为容器装这个发射枪的发出的子弹。
 */
public class TwoQueueStack {

    private Queue<Integer> queue1 = new LinkedList<>();

    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (queue2.size() != 0) {
            queue2.add(node);
        } else {
            queue1.add(node);
        }
    }

    public int pop() {
        if (queue1.size() == 0 && queue2.size() == 0) {
            return -1;
        }
        int element = -1;
        if (queue1.size() != 0) {
            while (queue1.size() > 0) {
                element = queue1.poll();
                if (queue1.size() != 0) {
                    queue2.add(element);
                }
            }
        } else {
            while (queue2.size() > 0) {
                element = queue2.poll();
                if (queue2.size() != 0) {
                    queue1.add(element);
                }
            }
        }
        return element;
    }

}
