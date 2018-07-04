package com.KwonGusung.string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * @author create2879
 *
 */
public class S1_SuperReducedString {

	// Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {

    	char[] chars = s.toCharArray();
    	
    	List<Character> charList = new ArrayList<>();
    	for(char c : chars) {
    		charList.add(c);
    	}
    	
    	Queue<Character> charQ = new LinkedList<>(charList);
    	
    	return removeString(charQ);
    }
    
    static String removeString(Queue<Character> charQ) {
    
    	int charQSize = charQ.size();
    	
    	Queue<Character> newCharQ = new LinkedList<>();
    
    	while(!charQ.isEmpty()) {
    		Character c1 = charQ.poll();
    		Character c2 = charQ.peek();
    		
    		if(c1 != c2) {
    			newCharQ.add(c1);
    		} else {
    			charQ.poll();
    		}
    	}
    	
    	if(charQSize == newCharQ.size()) {
    		String returnValue = "";
    		if(newCharQ.size() == 0) {
    			returnValue = "Empty String";
    		} else {
    			while(!newCharQ.isEmpty()) {
    				returnValue += String.valueOf(newCharQ.poll());
    			}
    		}
    		return returnValue;
    	} else {
    		return removeString(newCharQ);
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = super_reduced_string(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
