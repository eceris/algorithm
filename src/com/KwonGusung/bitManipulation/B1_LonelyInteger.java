package com.KwonGusung.bitManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/lonely-integer/problem
 * @author create2879
 *
 */
public class B1_LonelyInteger {

	// Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int i=0; i<a.length; i++) {
    		if(map.get(a[i]) == null) {
    			map.put(a[i], 1);
    		} else {
    			map.put(a[i], map.get(a[i]) + 1);
    		}
    	}
    	
    	int returnValue = -1;
    	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		if(entry.getValue() == 1) {
    			returnValue = entry.getKey();
    		}
    	}
    	
    	return returnValue;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    
}
