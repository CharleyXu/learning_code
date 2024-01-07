package com.xu.algorithm.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.
 *
 * 长按键入
 *
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
 *
 * 而字符可能被输入 1 次或多次。你将会检查键盘输入的字符 typed。
 *
 * 如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 示例：
 *
 * 输入：name = "alex", typed = "aaleex" 输出：true
 *
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 */
public class LongPressedName {

  /**
   * 时间复杂度：O(n)
   *
   * 空间复杂度：O(1)
   */
  private boolean isLongPressedName(String name, String type) {
    if (name == null || name.isEmpty() || type == null || type.isEmpty()) {
      return false;
    }
    char[] nameChars = name.toCharArray();
    char[] typeChars = type.toCharArray();
    int i = 0, j = 0;
    while (i < nameChars.length) {
      if (j >= typeChars.length) {
        return false;
      }
      if (nameChars[i] == typeChars[j]) {
        i++;
        j++;
      } else {
        if (j > 0 && typeChars[j - 1] == typeChars[j]) {
          j++;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  @Test
  public void isLongPressedNameTest() {
    String name = "alex", typed = "aaleex";
    boolean longPressedName = isLongPressedName(name, typed);
    System.out.println(longPressedName);
  }
}
