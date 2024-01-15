package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/15
 * <p>
 * 494 目标和
 * <p>
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1"
 * <p>
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * <p>
 * 输出：5
 * <p>
 * 解释：一共有 5 种方法让最终目标和为 3
 */
public class FindTargetSumWays {
    int count = 0;

    /**
     * 时间复杂度 O(2的n次方）
     */
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    /**
     * p 正数和，n 负数和的绝对值，
     * sum = p + n，target = p - n，
     * target = p -（sum - p）
     * target = 2p - sum
     * p =（target + sum）/ 2
     * <p>
     * 从nums中选取m个数，使其和为 (target + sum) / 2
     *
     *
     * <p>
     * dp[i][j] 表示在nums[0..i-1]中选出m个数(m<=i)使其和为j的方案数
     * <p>
     * dp[i][j] = dp[i-1][j] + dp[i-1][j]
     * <p>
     * 1. 子集法
     * <p>
     * 对每个数的策略变成了——选 | 不选
     */
    public int findTargetSumWaysSubCollection(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        // 奇偶
        if ((sum & 1) == 1) {
            return 0;
        }
        return dfs(nums, sum / 2, 0);
    }


    /**
     * 选/不选思想
     * <p>
     * 返回值表示从当前层开始考虑，目标和为target的数字组合的个数
     * <p>
     * dfs(n,target) = dfs(n-1,target) + dfs(n-1,target - nums[n])
     * <p>
     * 递推公式理解：表示当前解由不选当前数字和选当前数字的解的数目构成
     */
    private int dfs(int[] nums, int target, int layer) {
        if (layer == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return dfs(nums, target, layer + 1) + dfs(nums, target - nums[layer], layer + 1);
    }

    /**
     * 2. 自顶开始递归
     * <p>
     * `从n个数字中取m个数字使其和为target`这个问题，可以转化为`从n-1个数字中取m个数字使其和为target`与`从n-1个数字中取m-1个数字使其和为target`这两个子问题`解的合集`
     */
    public int findTargetSumWayRecursive(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        // 奇偶
        if ((sum & 1) == 1) {
            return 0;
        }
        return dfs2(nums, sum / 2, nums.length - 1);
    }

    private int dfs2(int[] nums, int target, int n) {
        if (n < 0) {
            return target == 0 ? 1 : 0;
        }
        return dfs2(nums, target, n - 1) + dfs2(nums, target - nums[n], n - 1);
    }

    /**
     * 记忆化搜索
     */
    public int findTargetSumWayMemorySearch(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        // 奇偶
        if ((sum & 1) == 1) {
            return 0;
        }
        // 定义数组记录dfs的结果
        int[][] memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs3(nums, sum / 2, nums.length - 1, memo);
    }

    private int dfs3(int[] nums, int target, int n, int[][] memo) {
        if (target < 0) {
            return 0;
        }
        if (n < 0) {
            return target == 0 ? 1 : 0;
        }
        if (memo[n][target] == -1) {
            memo[n][target] = dfs3(nums, target, n - 1, memo) + dfs3(nums, target - nums[n], n - 1, memo);
        }
        return memo[n][target];
    }

    /**
     * 记忆化搜索优化成01背包问题
     */
    public int findTargetSumWays01(int[] nums, int target) {
        int sum = target;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1 || sum < 0) return 0;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        // 注意：dp[0][0] 表示为递归树中的叶节点，表示考虑完nums中所有数且target已经为0的情况(即找到了一个解)，所以dp[0][0]需要初始化为1
        dp[0][0] = 1;
        // 因为是自下网上计算，所以需要先给出最小规模问题的解
        // 仅考虑第一个数，即nums[0]时，他仅能构成和为target = nums[0]的一个解
        // 如果nums[0] = 0，则 选 | 不选它都能构成target = 0的解，所以解有两个
        if (nums[0] < dp[0].length) {
            if (nums[0] == 0) {
                dp[0][nums[0]] = 2;
            } else {
                dp[0][nums[0]] = 1;
            }
        }
        // 自底向上计算
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        // 答案就是数组最后一个元素啦
        return dp[dp.length - 1][sum / 2];
    }


    /**
     * 动态规划的本质是对dfs的优化
     * <p>
     * 记忆化搜索优化成01背包问题
     * <p>
     * dfs(n,target) = dfs(n-1,target) + dfs(n-1,target - nums[n])
     */
    public int findTargetSumWaysDp(int[] nums, int target) {
        int sum = target;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1 || sum < 0) {
            return 0;
        }
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 1;
        // 因为是自下网上计算，所以需要先给出最小规模问题的解
        // 仅考虑第一个数，即nums[0]时，他仅能构成和为target = nums[0]的一个解
        // 如果nums[0] = 0，则 选 | 不选它都能构成target = 0的解，所以解有两个
        if (nums[0] < dp.length) {
            if (nums[0] == 0) {
                dp[nums[0]] = 2;
            } else {
                dp[nums[0]] = 1;
            }
        }
        // 自底向上计算
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        // 答案就是数组最后一个元素
        return dp[sum / 2];
    }

    @Test
    public void findTargetSumWaysTest() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
        System.out.println(findTargetSumWaysSubCollection(nums, 3));
        System.out.println(findTargetSumWayRecursive(nums, 3));
        System.out.println(findTargetSumWayMemorySearch(nums, 3));
        System.out.println(findTargetSumWays01(nums, 3));
        System.out.println(findTargetSumWaysDp(nums, 3));
    }

}
