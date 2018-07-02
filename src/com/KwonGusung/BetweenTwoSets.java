package com.KwonGusung;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/between-two-sets/problem
 * @author create2879
 *
 */
public class BetweenTwoSets {

	/*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
    	
    	Arrays.sort(b);
    	
    	List<Integer> overlaps = betweenAnB(a, b[0]);
    	for(int bValue : b) {
    		cd(overlaps, bValue);
    	}
    	
    	return overlaps.size();
    }
    
    /**
     * a 배열의 최소공배수 와 B 배열의 최소 수 사이에서 a 배열 배수를 조회
     * @param a
     * @param bValue
     * @return
     */
    static List<Integer> betweenAnB(int[] a, int bValue) {
    	
    	int lcm = 1;
    	for(int aValue : a) {
    		lcm = lcm(lcm, aValue);
    	}
    	
    	List<Integer> lcms = new ArrayList<>();
    	for(int i=1; (i*lcm)<=bValue; i++) {
    		lcms.add(lcm * i);
    	}
    	return lcms;
    }
    
    /**
     * 주어진 list 에서 n 의 약수인지 check
     */
    static void cd(List<Integer> overlaps, int n) {
    	List<Integer> newOverlaps = new ArrayList<>();
    	for(int overlap : overlaps) {
    		if(n % overlap == 0) {
    			newOverlaps.add(overlap);
    		}
    	}
    	overlaps.clear();
    	overlaps.addAll(newOverlaps);
    }

    /**
     * 최대공약수
     * 참조 : https://ko.wikipedia.org/wiki/%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98
     * @param n
     * @param m
     * @return
     */
    static int gcd(int n, int m) {
    	int quotient = m % n;
    	if(quotient == 0) {
    		return n;
    	} else {
    		return gcd(quotient, n);
    	}
    }
    
    /**
     * 최소공배수
     * 참조 : https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98
     * @param n
     * @param m
     * @return
     */
    static int lcm(int n, int m) {
    	return (n*m) / gcd(n, m);
    }
    
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
