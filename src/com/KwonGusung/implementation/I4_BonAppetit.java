package com.KwonGusung.implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 * @author create2879
 *
 */
public class I4_BonAppetit {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
		String[] firstLine = scanner.nextLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);

        int k = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = scanner.nextLine().split(" ");
        
        int[] bill = new int[n];
        for(int i=0; i<n; i++) {
        	bill[i] = Integer.parseInt(secondLine[i]);
        }
        
        int b = scanner.nextInt();
        
        System.out.println(bonAppetit(bill, k, b));
    }
	
	static String bonAppetit(int[] bill, int k, int b) {
		int sum = 0;
		for(int v : bill) {
			sum += v;
		}
		
		BigDecimal bSum = new BigDecimal(sum - bill[k]);
		BigDecimal num = new BigDecimal(2);
		
		
		int result = bSum.divide(num).intValue();
		
		if(b - result == 0) {
			return "Bon Appetit";
		} else {
			return String.valueOf(b - result);
		}
	}
}
