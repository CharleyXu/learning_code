package com.xu.algorithm.array;

/**
 * Created by CharleyXu on 2020-06-09
 */
public class Fib {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        int a = 0;
        int b = 1;
        int temp = 0;
        for (int i = 3; i <= N; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

}
