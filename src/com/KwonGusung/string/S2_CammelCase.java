package com.KwonGusung.string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 * @author create2879
 *
 */
public class S2_CammelCase {

	
	// Complete the camelcase function below.
    static int camelcase(String s) {

    	char[] charArray = s.toCharArray();
    	
    	int count = s.length() > 0 ? 1 : 0;
    	for(int i=0; i< charArray.length; i++) {
    		count += isUpper(charArray[i]);
    	}
    	
    	return count;
    }
    
    static int isUpper(char c) {
    	int upperA = (int) 'A';
    	int upperZ = (int) 'Z';
    	if(upperA <= (int) c && upperZ >= (int) c) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
