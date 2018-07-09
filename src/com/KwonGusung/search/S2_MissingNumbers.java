package com.KwonGusung.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/missing-numbers/problem
 * @author create2879
 *
 */
public class S2_MissingNumbers {

	// Complete the missingNumbers function below.
	static int[] missingNumbers(int[] arr, int[] brr) {
		
		Arrays.sort(arr);
		Arrays.sort(brr);
		
		int aSearchIndex = 0;
		
		Set<Integer> missingNumberSet = new HashSet<>();
		for(int v : brr) {
			// arr 를 search 다 했을 경우 나머지는 못찾은 Set 에 넣는다.
			if(aSearchIndex >= arr.length) {
				missingNumberSet.add(v);
				continue;
			}
			// 있으면 다음 index 로 변경 없으면 못찾은 Set 에 넣음.
			if(v == arr[aSearchIndex]) {
				aSearchIndex++;
			} else {
				missingNumberSet.add(v);
			}
		}
		
		int[] returnValue = new int[missingNumberSet.size()];
		int i = 0;
    	for(int v : missingNumberSet) {
    		returnValue[i++] = v;
    	}
    	Arrays.sort(returnValue);
		return returnValue;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
