package com.eceris.hackerrank.implementation;

//  https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class I1_DivisibleSumPairs {

    public static void main(String[] args) {
        int n = 6, k = 3;
        int ar[] = {1, 3, 2, 6, 1, 2}; //5

        int i = divisibleSumPairs(n, k, ar);
        System.out.println(i);
    }

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    System.out.println(ar[i] + " " + ar[j]);
                    count++;
                }
            }
        }
        return count;
    }
}
