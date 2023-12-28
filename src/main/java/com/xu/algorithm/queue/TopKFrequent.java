package com.xu.algorithm.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2023/12/7
 * <p>
 * 347 前 K 个高频元素
 */
public class TopKFrequent {

    /***
     * 时间复杂度 O(n log k)
     * 空间复杂度 O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // int[] ([num, count])的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> m[1] - n[1]);

        map.forEach((num, count) -> {
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        });
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

}
