package com.xu.algorithm.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.
 *
 * 左旋转字符串
 */
public class LeftRotateString {

  /**
   * 1）先翻转第一部分
   *
   * 2）翻转第二部分
   *
   * 3）整体翻转
   */
  private String leftRotateString(String string, int num) {
    if (string == null || string.length() < 2 || string.length() <= num) {
      throw new RuntimeException();
    }
    //
    char[] chars = string.toCharArray();
    reverseArray(chars, 0, num - 1);
    reverseArray(chars, num, chars.length - 1);
    reverseArray(chars, 0, chars.length - 1);
    return new String(chars);
  }

  private void reverseArray(char[] chars, int start, int end) {
    while (start < end) {
      char temp = chars[start];
      chars[start++] = chars[end];
      chars[end--] = temp;
    }
  }

  @Test
  public void leftRotateStringTest() {
    //字符序列S="abcXYZdef",要求输出循环左移3位后的结果，即"XYZdefabc"
    String string = "abcXYZdef";
    String result = leftRotateString(string, 4);
    System.out.println(result);
  }

}
