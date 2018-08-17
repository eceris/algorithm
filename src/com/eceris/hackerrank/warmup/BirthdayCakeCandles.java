package com.eceris.hackerrank.warmup;

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem
public class BirthdayCakeCandles {
    public static void main(String[] args) {
        int[] ar = {3, 2, 3, 3};
        System.out.println(birthdayCakeCandles(ar));
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i : ar) {
            if (i > max) {
                count = 0;
                max = i;
            }
            if (i == max) {
                count++;
            }
        }
        return count;
    }
}
