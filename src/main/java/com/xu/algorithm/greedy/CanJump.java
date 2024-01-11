package com.xu.algorithm.greedy;

import org.junit.Test;

import java.util.*;

/**
 * Created by CharleyXu on 2023/12/20
 * <p>
 * 55 跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * nums = [2,3,1,1,4]
 * <p>
 * true
 * <p>
 * nums = [3,2,1,0,4]
 * <p>
 * false
 */
public class CanJump {

    /**
     * 贪心
     * <p>
     * 跳跃的最大长度为 x+nums[x]
     * <p>
     * 依次遍历数组中的每一个元素，实时维护最远可以到达的位置
     * <p>
     * 如果最远可以到达的位置，大于等于数组中的最后一个位置，说明最后一个位置可以到达，直接返回true
     * <p>
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 45 跳跃游戏II
     * <p>
     * 贪心
     * 返回到达 nums[n - 1] 的最小跳跃次数
     * <p>
     * 跳跃的最大长度为 x+nums[x]
     * <p>
     * 时间复杂度 O(n)，空间复杂度 O(1)
     * <p>
     * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
     * <p>
     * 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，
     * <p>
     * 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * <p>
     * 输出: 2
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 1306 跳跃游戏III
     * <p>
     * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
     * <p>
     * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
     * <p>
     * 注意，不管是什么情况下，你都无法跳到数组之外。
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [4,2,3,0,3,1,2], start = 5
     * <p>
     * 输出：true
     * <p>
     * 解释：
     * <p>
     * 到达值为 0 的下标 3 有以下可能方案：
     * <p>
     * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
     * <p>
     * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        // mark it visited
        visited[index] = true;
        return dfs(arr, index + arr[index], visited) || dfs(arr, index - arr[index], visited);
    }

    public boolean canReachBfs(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur < 0 || cur >= arr.length || visited[cur]) {
                continue;
            }
            if (arr[cur] == 0) {
                return true;
            }
            // mark it visited
            visited[cur] = true;
            queue.offer(cur + arr[cur]);
            queue.offer(cur - arr[cur]);
        }
        return false;
    }

    /**
     * 1345 跳跃游戏 IV
     * <p>
     * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
     * <p>
     * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
     * <p>
     * i + 1 需满足：i + 1 < arr.length
     * <p>
     * i - 1 需满足：i - 1 >= 0
     * <p>
     * j 需满足：arr[i] == arr[j] 且 i != j
     * <p>
     * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
     * <p>
     * 注意：任何时候你都不能跳到数组外面。
     * <p>
     * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
     * <p>
     * 输出：3
     * <p>
     * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
     * <p>
     * 思路：首次到达的末尾点的元素，必然是最小步数
     * <p>
     * 时间复杂度 O(N)
     */
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> idxSameValueMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxSameValueMap.putIfAbsent(arr[i], new ArrayList<>());
            idxSameValueMap.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == n - 1) {
                return step;
            }
            int v = arr[idx];
            step++;
            //  相同元素位置
            if (idxSameValueMap.containsKey(v)) {
                for (Integer i : idxSameValueMap.get(v)) {
                    if (visited.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                // 访问过某个节点后，即会将所有其他与其元素相同的节点都放入队列。经过这个过程之后直接将该元素移出哈希表避免重复访问
                idxSameValueMap.remove(v);
            }
            // 向右
            if (idx + 1 < n && visited.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            // 向左
            if (idx - 1 >= 0 && visited.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }

    @Test
    public void minJumpsTest() {
        int[] nums = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(nums));
    }

    @Test
    public void jumpTest() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

}
