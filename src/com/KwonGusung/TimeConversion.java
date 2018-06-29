package com.KwonGusung;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 * @author create2879
 *
 */
public class TimeConversion {

	/*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
    	String convertDate = s.substring(0, 8);
    	String[] dateSplits = convertDate.split(":", 2);
    	int convertHhIntVal = Integer.parseInt(dateSplits[0]) % 12;
    	
    	String convertHh;
    	if(s.contains("PM")) {
    		convertHhIntVal += 12;
    	}
    	convertHh = String.valueOf(convertHhIntVal);
    	return (convertHh.length() == 1 ? "0" + convertHh : convertHh) + ":" + dateSplits[1];
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
