package com.eceris.hackerrank.implementation;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

public class I0_BreakingtheRecords {
    public static void main(String[] args) {

//        int [] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};    //2 4
        int [] scores = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};    //4 0
        int[] ints = breakingRecords(scores);
        System.out.println(ints);
    }

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int countOfHigh = 0;
        int countOfLow = 0;

        int highTemp = Integer.MIN_VALUE;
        int lowTemp = Integer.MAX_VALUE;

        for(int i = 0; i< scores.length ; i++) {
            if (i == 0) {
                highTemp =scores[i];
                lowTemp =scores[i];
                continue;
            }
            if (scores[i] > highTemp) {
                highTemp = scores[i];
                countOfHigh++;
            }
            if (scores[i] < lowTemp) {
                lowTemp = scores[i];
                countOfLow++;
            }
        }

        int [] result = {countOfHigh, countOfLow};
        return result;
    }

}
