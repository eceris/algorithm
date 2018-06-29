package com.KwonGusung;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 * @author create2879
 *
 */
public class MiniMaxSum {

	// Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

    	long maxValue = arr[0];
    	long minValue = arr[0];
    	
    	long sumValue = 0;
    	for(int value : arr) {
    		if(maxValue < value) {
    			maxValue = value;
    		}
    		if(minValue > value) {
    			minValue = value;
    		}
    		sumValue += value;
    	}
    	
    	long maxSumValue = sumValue - minValue;
    	long minSumValue = sumValue - maxValue;
    	System.out.println(minSumValue + " " + maxSumValue);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
