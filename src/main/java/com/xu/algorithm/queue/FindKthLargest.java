package com.xu.algorithm.queue;


import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author CharleyXu Created on 2019/3/25.
 * <p>
 * Kth Largest Element in an Array(找出无序数组第K大的元素)
 * <p>
 * 相似 Find K Pairs with Smallest Sums(题目描述，自行Leetcode)
 */
public class FindKthLargest {

    /**
     * 使用优先队列
     * <p>
     * 小顶堆
     * <p>
     * 执行了𝑛 轮入堆和出堆，堆的最大长度为 𝑘
     * <p>
     * 因此时间复杂度为 𝑂(𝑛 log 𝑘) 。该方法的效率很高，
     * <p>
     * 当𝑘 较小时，时间复杂度趋向 𝑂(𝑛) ;当 𝑘 较大时，时间复杂度不会超过 𝑂(𝑛 log 𝑛)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    @Test
    public void findKthLargestTest() {
        int[] nums = new int[]{13, 5, 32, 5, 7, 1, 7};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

}
