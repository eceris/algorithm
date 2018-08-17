package com.eceris.hackerrank.warmup;

//https://www.hackerrank.com/challenges/mini-max-sum/problem

public class MiniMaxSum {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5,};

        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i : arr) {
            sum += i;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
}
