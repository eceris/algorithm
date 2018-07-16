package com.KwonGusung.bitManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor/problem
 * @author create2879
 *
 */
public class B2_MaximizingXOR {
	
	public static void main(String[] args) {
		int result = maximizingXor(10, 15);
		System.out.println(result);
	}

	// Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {

    	int index = 0;
    	int max = 0;
    	for(int i=l; i<=r; i++) {
    		for(int j=l + index++; j<=r; j++) {
    			int temp = i ^ j;
    			if(max < temp) {
    				max = temp;
    			}
    		}
    	}
    	return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
