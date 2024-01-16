package com.xu.algorithm.string;

/**
 * Created by CharleyXu on 2024/1/16
 * <p>
 * 383 赎金信
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * <p>
 * 输出：false
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int rLen = ransomNote.length();
        int mLen = magazine.length();
        if (rLen > mLen) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < mLen; i++) {
            nums[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < rLen; i++) {
            int idx = ransomNote.charAt(i) - 'a';
            nums[idx]--;
            if (nums[idx] < 0) {
                return false;
            }
        }
        return true;
    }
}
