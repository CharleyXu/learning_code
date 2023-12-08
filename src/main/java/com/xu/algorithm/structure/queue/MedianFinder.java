package com.xu.algorithm.structure.queue;

import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 数据流的中位数
 */
public class MedianFinder {

    PriorityQueue<Integer> queMin;

    PriorityQueue<Integer> queMax;

    /**
     * 空间复杂度 O(n)
     */
    public MedianFinder() {
        // 记录大于中位数的数和小于等于中位数的数
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    /**
     * 时间复杂度 O(logn)
     */
    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
