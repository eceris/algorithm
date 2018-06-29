package com.KwonGusung;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

	// Complete the staircase function below.
    static void staircase(int n) {

    	for(int index=0; index<n; index++) {
    		int spaceSize = n - index -1;
    		StringBuilder sb = new StringBuilder();
    		for(int spaceIndex=0; spaceIndex<spaceSize; spaceIndex++) {
    			sb.append(" ");
    		}
    		int sharpSize = index + 1;
    		for(int sharpIndex=0; sharpIndex<sharpSize; sharpIndex++) {
    			sb.append("#");
    		}
    		System.out.println(sb.toString());
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
