package com.xu.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharleyXu on 2024/1/12
 * <p>
 * 118. 杨辉三角
 * <p>
 * 定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 输入: numRows = 5
 * <p>
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class GenerateTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    integers.add(1);
                } else {
                    integers.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(integers);
        }
        return res;
    }

    @Test
    public void generateTest() {
        System.out.println(generate(5));
    }
}
