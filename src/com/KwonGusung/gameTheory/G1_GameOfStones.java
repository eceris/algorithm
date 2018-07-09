package com.KwonGusung.gameTheory;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class G1_GameOfStones {

	// Complete the gameOfStones function below.
    static String gameOfStones(int n) {

    	if(isFirstWin(n)) {
    		return "First";
    	} else {
    		return "Second";
    	}
    }
    
    // 내가 마지막돌을 부를수 있거나, 돌을 움직이지 못하게 1을 만들면 이기게됨. (2,3,4,5,6 을 가지면 무조건 이김)
    // => 님 게임 참조 => 내가 낼수 있는 최소 값과, 상대방이 낼수 있는 최대값 => (2, 5) => 7
    static boolean isFirstWin(int n) {
    	int quota = n % 7;
    	
    	if(quota == 2 || quota == 3 || quota == 5) {
    		return true;
    	} else if(quota == 3|| quota == 4 || quota == 6) {
    		return true;
    	} else {
    		return false;
    	}
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = gameOfStones(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
    
}
