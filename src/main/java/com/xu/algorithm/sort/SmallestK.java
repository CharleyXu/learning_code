package com.xu.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2020-06-18
 * <p>
 * 最小K个数
 */
public class SmallestK {

    /**
     * 最小堆
     * <p>
     * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
     * 输出： [1,2,3,4]
     */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
        Arrays.stream(arr).forEach(minHeap::offer);
        int[] result = new int[k];
        int idx = 0;
        while (idx < k) {
            result[idx++] = minHeap.poll();
        }
        return result;
    }

    /**
     * 最大堆
     */
    public int[] largestK(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        int[] result = new int[k];
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (maxHeap.peek() < num) {
                // 如果堆顶元素 < 新数，则删除堆顶，加入新数入堆
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    @Test
    public void smallestKTest() {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(Arrays.toString(smallestK(arr, k)));
    }

    @Test
    public void largestKTest() {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 2;
        System.out.println(Arrays.toString(largestK(arr, k)));
    }

}
