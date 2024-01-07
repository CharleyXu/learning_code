package com.xu.algorithm.array;

import org.junit.Test;

/**
 * @author charlie Created on 2018/1/31.
 *
 * 给出一个排序好的数组和一个数,求数组中连续元素的和等于所给数的子数组
 */
public class FindSubArray {

	public void findSubArray(int[] arr, int num) {
		int left;
		int right;
		for (int i = 0, size = arr.length; i < size; i++) {
			int currentNum = 0;
			left = i;
			right = i;
			while (currentNum < num && right < size) {
				currentNum += arr[right++];
			}
			if (currentNum == num) {
				for (int j = left; j < right; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
		}
	}

	@Test
	public void test() {
		int[] arr = {1, 2, 2, 3, 4, 5, 7, 8, 9, 10};
		int num = 12;
		findSubArray(arr, num);
	}


}
