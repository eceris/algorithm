package com.KwonGusung;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppleAndOrange {

	// Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

    	int[] convertApplePoints = convertPoint(a, apples);
    	int[] convertOrangePoints = convertPoint(b, oranges);
    	
    	int minPoint = s <= t ? s : t;
    	int maxPoint = s > t ? s : t;
    	
    	System.out.println(count(minPoint, maxPoint, convertApplePoints));
    	System.out.println(count(minPoint, maxPoint, convertOrangePoints));

    }
    
    static int[] convertPoint(int target, int[] points) {
    	int[] convertPoints = new int[points.length];
    	
    	for(int index=0; index < points.length; index++) {
    		convertPoints[index] = target + points[index];
    	}
    	
    	return convertPoints;
    }
    
    static int count(int minPoint, int maxPoint, int[] points) {
    	
    	int count = 0;
    	for(int point : points) {
    		if(minPoint <= point && maxPoint >= point) {
    			count++;
    		}
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
