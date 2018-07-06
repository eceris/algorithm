package com.KwonGusung.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * @author create2879
 *
 */
public class G1_MinimumAbsoluteDifferenceInAnArray {

	// Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

    	// 정렬을 시도 -> 만약 그냥 시도 했을 경우는 전체 탐색이 이루어져야함. 이때 n2 이 발생
    	// 하지만 정렬을 먼저 했을 경우 인접하는 두개만 서로 비교 해도됨.
    	// 따라서 정렬의 속도에 따라 실제 탐색은 n 번만 이뤄지게됨. 정렬은 nlogn 이나 선택된 정렬 알고리즘에 따라 달라짐.
    	Arrays.sort(arr);
    	
    	int minValue = Math.abs(arr[0] - arr[1]);
    	for(int i=1; i<arr.length-1; i++) {
    		int tempValue = Math.abs(arr[i] - arr[i+1]);
    		if(minValue > tempValue) {
    			minValue = tempValue;
    		}
    	}
    	return minValue;
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[]{3, -7, 0};
    	System.out.println(minimumAbsoluteDifference(arr));
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
	
}
