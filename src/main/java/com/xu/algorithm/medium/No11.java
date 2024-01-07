package com.xu.algorithm.medium;

/**
 * Container With Most Water
 */
public class No11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int low = 0, high = height.length - 1;
        int max = 0;
        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);

            max = Math.max(max, area);
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return max;
    }

}
