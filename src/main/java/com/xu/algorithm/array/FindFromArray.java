package com.xu.algorithm.array;

/**
 * @author CharleyXu Created on 2018/9/28.
 *
 * 二维数组寻找特定值
 */
public class FindFromArray {

  public static void main(String[] args) {
    int[][] array = new int[2][3];
    array[0][0] = 1;
    array[0][1] = 3;
    array[0][2] = 5;
    array[1][0] = 2;
    array[1][1] = 4;
    array[1][2] = 6;
    System.out.println(find(6,array));
  }

  public static boolean find(int target, int[][] array) {
    int width = array.length;
    int length = array[0].length;
    if (width < 1 || length < 1) {
      return false;
    }
    int firstIndex = 0;
    int secondIndex = length-1;
    while (firstIndex <width && secondIndex>=0){
      if(array[firstIndex][secondIndex]==target){
        return true;
      }else if (array[firstIndex][secondIndex] < target){
        firstIndex = firstIndex + 1;
      }else if (array[firstIndex][secondIndex] > target){
        secondIndex = secondIndex-1;
      }
    }
    return false;
  }

}
