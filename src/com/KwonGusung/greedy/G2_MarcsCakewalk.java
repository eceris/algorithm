package com.KwonGusung.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/marcs-cakewalk/problem
 * @author create2879
 *
 */
public class G2_MarcsCakewalk {
	
	public static void main(String[] args) {
		marcsCakewalk(new int[]{1, 3, 2});
	}

	// Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {

    	quickSort(calorie, 0, calorie.length - 1);
		
    	long maxValue = 0;
    	for(int i=0; i< calorie.length; i++) {
    		long temp = calorie[i] * (long) Math.pow(2, i);
    		maxValue += temp;
    	}
    	
    	return maxValue;

    }
    
    static void quickSort(int[] arr, int left, int right) {		
		if(left < right) {
			
			int pivotIndex = (left + right) / 2;
			int pivotValue = arr[pivotIndex];
			
			int lIndex = left;
			int rIndex = right;
			while(lIndex <= rIndex) {
				
				// pivot 보다 큰것이 나올때 까지 index 구함
				while(arr[lIndex] > pivotValue) {
					lIndex++;
				}
				
				// pivot 보다 작은것이 나올때 까지 index 구함
				while(arr[rIndex] < pivotValue) {
					rIndex--;
				}
				
				// 왼쪽탐색중 pivot 보다 큰것과 오른쪽 탐색중 pivot 보다 작은것을 서로 교체
				if(lIndex <= rIndex) {
					swap(arr, lIndex, rIndex);	
					lIndex++;
					rIndex--;
				}
				
			}
			
			if(left < rIndex) {
				quickSort(arr, left, rIndex);				
			}
			if(lIndex < right) {
				quickSort(arr, lIndex, right);				
			}
		}
	}
	
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
