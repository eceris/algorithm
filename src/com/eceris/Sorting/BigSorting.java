package com.eceris.Sorting;

import java.util.Arrays;
import java.util.Comparator;

//  https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {
    public static Number[] sorted;

    public static void main(String[] args) {
//        String[] unsorted = {"6", "31415926535897932384626433832795", "1", "3", "10", "3", "5",};
        String[] unsorted = {"1000", "185268471237394664404712612887434360655188980698758068018366607853573284058797902196156532088814"};
        String[] strings = bigSorting(unsorted);
        System.out.println(String.join(", ", strings));
    }

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    String[] o1split = o1.split("");
                    String[] o2split = o2.split("");
                    for (int i = 0; i < o1.length(); i++) {
                        int result = o1split[i].compareTo(o2split[i]);
                        if (result < 0) {
                            return -1;
                        } else if (result > 0) {
                            return 1;
                        }
                    }
                    return 0;
                }
            }
        });
        return unsorted;
    }


}
