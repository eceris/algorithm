package com.KwonGusung.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 * @author create2879
 *
 */
public class I3_DayOfTheProgrammer {

	 // Complete the solve function below.
    static String solve(int year) {

    	boolean isLeapYear = false;
    	if(year >= 1700 && year <= 1918) {
    		if(year % 4 == 0) {
    			isLeapYear = true;
    		}
    	} else {
    		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
    			isLeapYear = true;
    		}
    	}
    	
    	boolean isCrazyYear = (year == 1918);
    	
    	String returnValue = ".09." + String.valueOf(year);
    	
    	int day;
    	if(isLeapYear) {
    		day = 12;
    	} else {
    		day = 13;
    	}
    	if(isCrazyYear) {
    		day += 13;
    	}
    	return String.valueOf(day) + returnValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
