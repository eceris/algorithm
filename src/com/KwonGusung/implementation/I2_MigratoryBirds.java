package com.KwonGusung.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * @author create2879
 *
 */
public class I2_MigratoryBirds {

	// Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
    	
    	Arrays.sort(ar);
    	
    	int maxBirds = ar[0];
    	int tempBirds = ar[0];
    	int maxCount = 0;
    	int tempCount = 0;
    	
    	for(int i=0; i<ar.length; i++) {
    		if(tempBirds != ar[i]) {
    			if(tempCount > maxCount) {
    				maxBirds = ar[i-1];
    				maxCount = tempCount;
    			}
    			tempBirds = ar[i];
    			tempCount = 0;    			
    		}
    		tempCount++;
    	}
    	
    	// 마지막 확인
    	if(tempCount > maxCount) {
    		maxBirds = ar[ar.length - 1];
    	}
    	
    	return maxBirds;

    }
    
    public static void main(String[] args) {
    	int[] a = new int[]{1,4,4,4,5,3};
		
		System.out.println(migratoryBirds(a));
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
