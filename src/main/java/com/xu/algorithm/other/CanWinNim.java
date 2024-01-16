package com.xu.algorithm.other;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 292 Nim游戏
 * <p>
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合， 你作为先手
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * <p>
 * 输出：false
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：n = 2
 * 输出：true
 */
public class CanWinNim {

    /**
     * 当起始局面石子数量为 4 的倍数，则先手必败，否
     * <p>
     * 则先手必胜（即 n % 4 != 0 时，先手必胜）
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
