package com.xu.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2024/1/19
 * <p>
 * 179 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    @Test
    public void largeNumberTest() {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }


}
