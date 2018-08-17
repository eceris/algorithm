package com.eceris.hackerrank.implementation;

//  https://www.hackerrank.com/challenges/the-birthday-bar/problem

public class I0_BirthdayChocolate {

    public static void main(String[] args) {

//        int[] s = {2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1}; //3
//        int d = 18, m = 7;

//        int [] s = {1, 2, 1, 3, 2}; //2
//        int d = 3, m = 2;
//
//        int [] s = {1, 1, 1, 1, 1, 1}; //0
//        int d = 3, m = 2;
//
//        int [] s = {4}; //1
//        int d = 4, m = 1;

        int[] s = {2, 2, 1, 3, 2}; //2
        int d = 4, m = 2;
        int solve = solve(s, d, m);
        System.out.println(solve);

    }

    // Complete the solve function below.
    static int solve(int[] s, int d, int m) {
        int sum[] = new int[105];
        int count = 0;
        sum[0] = 0;
        // sum0 =0, sum1 = 0 +s0, sum2= s0 + s1, sum3 = s0 + s1 + s2, .....
        for (int i = 0; i < s.length; i++) {
            sum[i + 1] = sum[i] + s[i];
        }
        for (int i = 0; i <= s.length - m; i++) {
            if (sum[i + m] - sum[i] == d) {
                count++;
            }
        }
        return count;
    }
}
