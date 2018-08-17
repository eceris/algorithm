package com.eceris.hackerrank.greedy;

import java.util.Arrays;

public class G1_MinimumAbsoluteDifferenceInAnArray {

    public static void main(String[] args) {
//        int arr[] = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
//        int arr[] = {3, -7, 0};
//        int arr[] = {1, -3, 71, 68, 17};
        int arr[] = {100000,
                636651840, 845593958, 514430275 ,950990774 ,89897149 ,679801372 ,575598744 ,260814438 ,500059913 ,88191};

        int i = minimumAbsoluteDifference(arr);

        System.out.println(i);
    }
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int temp = Math.abs(arr[0] - arr[1]);
        for (int i = 0; i < arr.length -1; i++) {
            int abs = Math.abs(arr[i] - arr[i+1]);
            if (abs < temp) {
                temp = abs;
            }
        }
        return temp;
    }

}
