package com.xu.algorithm.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CharleyXu on 2020-08-13
 * <p>
 * 895 最大频率栈
 * <p>
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * <p>
 * FreqStack 有两个函数：push(int x)，将整数 x 推入栈中。
 * <p>
 * pop()，它移除并返回栈中出现最频繁的元素。
 * <p>
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * <p>
 * ◼ 示例： push [5,7,5,7,4,5] pop() -> 返回 5，因为 5 是出现频率最高的。
 * <p>
 * 栈变成 [5,7,5,7,4]。 pop() -> 返回 7，因为 5 和 7 都是频率最高的，
 * <p>
 * 但 7 最接近栈 顶。 栈变成 [5,7,5,4]。 pop() -> 返回 5 。
 * <p>
 * 栈变成 [5,7,4]。 pop() -> 返回 4 。 栈变成 [5,7]。
 * <p>
 * 令 freq 作为 x 的出现次数的映射 Map。
 * <p>
 * 此外 maxfreq，即栈中任意元素的当前最大频率，因为我们必须弹出频率最高的元素
 */
public class FreqStack {

    private Map<Integer, Integer> freq = new HashMap<>();
    private Map<Integer, List<Integer>> group = new HashMap<>();
    private int max = 0;

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        List<Integer> list = group.getOrDefault(f, new ArrayList<>());
        list.add(val);
        group.put(f, list);
        max = Math.max(max, f);
    }

    public int pop() {
        List<Integer> list = group.get(max);
        int ans = list.remove(list.size() - 1);
        freq.put(ans, freq.get(ans) - 1);
        if (list.isEmpty()) {
            max--;
        }
        return ans;
    }
}
