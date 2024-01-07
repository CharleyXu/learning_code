package com.xu.algorithm.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/28.
 *
 * 字符串匹配  Sunday算法
 */
public class Sunday {

  /**
   * O(m/n) ~ O(m*n)
   *
   * 判断p是否为s的子串
   *
   * @return p第一次出现的下标
   *
   * 核心在于通过跳过尽可能多的字符来提高匹配效率
   *
   * 每次观察对齐位置末尾的后一位字符在匹配字符串中从后往前最先出现的位置(预处理后时间复杂度为O(1) ) k，
   *
   * 移动m-k位，如果不存在则会初始化为-1
   */
  public int sundaySearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    int i, j;
    int skip = -1;
    for (i = 0; i <= M - N; i += skip) {
      for (j = 0; j < N; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          if (i == M - N) {
            break;
          }
          skip = N - getIndex(pat, txt.charAt(i + N));
          break;
        }
      }
      if (j == N) {
        return i;
      }
    }
    return -1;
  }

  private int getIndex(String pat, Character c) {
    for (int i = pat.length() - 1; i >= 0; i--) {
      if (pat.charAt(i) == c) {
        return i;
      }
    }
    return -1;
  }

  private int contains(char[] chars, char target) {
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == target) {
        return i;
      }
    }
    return -1;
  }


  @Test
  public void sundayTest() {
    String s = "111GoodMorning123";
    String p = "ning12";
    System.out.println(sundaySearch(s, p));
  }

  @Test
  public void sundayAllTest() {
    String s = "abcdebcdbcdebcde";
    String p = "bcde";
    sundayAll(s, p);
  }

  /**
   * 。。。
   */
  public void sundayAll(String dest, String pattern) {

    char[] destChars = dest.toCharArray();
    char[] patternChars = pattern.toCharArray();

    int i = 0;
    int j = 0;

    while (i <= (dest.length() - pattern.length() + j)) {
      if (destChars[i] != patternChars[j]) {
        if (i == (dest.length() - pattern.length() + j)) {
          break;
        }
        int pos = contains(patternChars, destChars[i + pattern.length() - j]);
        if (pos == -1) {
          i = i + pattern.length() + 1 - j;
          j = 0;
        } else {
          i = i + pattern.length() - pos - j;
          j = 0;
        }
      } else {
        if (j == (pattern.length() - 1)) {
          System.out.println("the start pos is " + (i - j) + " the end pos is " + i);
          i = i - j + 1;
          j = 0;
        } else {
          i++;
          j++;
        }
      }
    }
  }


}
