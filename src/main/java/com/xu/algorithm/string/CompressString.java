package com.xu.algorithm.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/15.
 *
 * 压缩字符串
 *
 * 空间O(1)
 *
 * 输入：
 *
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 *
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 *
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 */
public class CompressString {

  public int compressString(String string) {
    if (string == null || string.isEmpty() || string.length() < 2) {
      return 0;
    }
    char[] chars = string.toCharArray();
    int length = 0;

    for (int i = 0; i < chars.length; ) {
      chars[length++] = chars[i++];
      int count = 1;
      while (i < chars.length && chars[i - 1] == chars[i]) {
        i++;
        count++;
      }
      if (count > 1) {
        String s = String.valueOf(count);
        for (int j = 0; j < s.length(); j++) {
          chars[length++] = s.charAt(j);
        }
      }
    }
    System.out.println(new String(chars));
    return length;
  }

  @Test
  public void compressStringTest() {
    String string = "AAABCCedfff";
    int result = compressString(string);
    System.out.println(result);
  }


}
