package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2024/1/3
 */
public class Convert {

    /**
     * 时间复杂度 O(N)
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        //
        if (n == 1 || numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                int rowOffset = 2 * (numRows - 1) - 1;
                while (j < n) {
                    stringBuilder.append(s.charAt(j));
                    j += rowOffset + 1;
                }
            } else {
                int j = i;
                int topRow = i;
                int topOffset = 2 * topRow - 1;
                int buttomRow = numRows - i - 1;
                int buttomOffset = 2 * buttomRow - 1;
                boolean flag = true;
                while (j < n) {
                    stringBuilder.append(s.charAt(j));
                    j += flag ? buttomOffset + 1 : topOffset + 1;
                    flag = !flag;
                }
            }
        }
        return stringBuilder.toString();
    }

}
