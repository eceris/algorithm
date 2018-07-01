package com.eceris;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//https://www.hackerrank.com/challenges/between-two-sets/problem
public class BetweenTwoSets {
    public static void main(String[] args) {
        int[] a = {2, 4};
        int[] b = {16, 32, 96};

        int totalX = getTotalX(a, b);
        System.out.println(totalX);
    }

    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        HashSet<Integer> commonMultiple = getCommonMultiple(a);
        HashSet<Integer> commonFactor = getCommonFactor(b);

        Iterator<Integer> iterator = commonFactor.iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(commonMultiple.contains(next)) {
                System.out.println(next);
                count++;
            }
        }
        return count;
    }

    static HashSet<Integer> getCommonMultiple(int a[]) {
        HashSet<Integer> commonMultiple = new HashSet<>();
        for(int i : a) {
            commonMultiple.addAll(getMultiple(i));
        }
        return commonMultiple;
    }
    static List<Integer> getMultiple(int v) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            multiples.add(i*v);
        }
        return multiples;
    }
    //약수
    static HashSet<Integer> getCommonFactor(int b[]) {
        HashSet<Integer> commonFactor = new HashSet<>();
        for(int i : b) {
            commonFactor.addAll(getFactor(i));
        }
        return commonFactor;
    }
    static List<Integer> getFactor(int v) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= v; i++) {
            if (v % i ==0) {
                factors.add(i);
            }
        }
        return factors;
    }
    static void check(HashSet<Integer> commonFactor, List<Integer> factors) {
        for (Integer i : factors) {

        }
    }
}
