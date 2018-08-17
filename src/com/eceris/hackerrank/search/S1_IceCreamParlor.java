package com.eceris.hackerrank.search;

import java.util.Arrays;

//    https://www.hackerrank.com/challenges/icecream-parlor/problem
public class S1_IceCreamParlor {
    public static void main(String[] args) {
        int m = 4;
        int arr[] = {2, 2, 4, 3};
//        int m = 4;
//        int arr[] = {1, 4, 5, 3, 2};
        int[] ints = icecreamParlor(m, arr);
        Arrays.stream(ints).forEach(System.out::println);
    }

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m) {
                    result[0] = i+1;
                    result[1] = j+1;
                    break;
                }
            }
        }
        return result;
    }
}
