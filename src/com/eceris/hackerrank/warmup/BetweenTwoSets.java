package com.eceris.hackerrank.warmup;

import java.util.*;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/between-two-sets/problem
public class BetweenTwoSets {
    public static void main(String[] args) {
        int[] a = {2, 4};
        int[] b = {16, 32, 96};

        //요 케이스는 잘 모르것다 ...ㅠㅠ
//        int[] a = {1};
//        int[] b = {100};

        int totalX = getTotalX(a, b);
        System.out.println(totalX);
    }

    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        List<Integer> multiple = getMultiple(a);
        HashSet<Integer> commonFactor = getCommonFactor(b);

        Iterator<Integer> iterator = commonFactor.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (multiple.contains(next)) {
                count++;
            }
        }
        return count;
    }

    //최대 공약수
    static int getGcd(int n, int m) {
        int remaind = m % n;
        if (remaind == 0) {
            return n;
        }
        return getGcd(remaind, n);
    }

    static int getGcd(int... values) {
        int gcd = 1;
        for (int i : values) {
            gcd = getGcd(gcd, i);
        }
        return gcd;
    }

    //최대 공배수
    static int getLcm(int m, int n) {
        return (m * n) / getGcd(m, n);
    }

    static int getLcm(int... values) {
        int lcm = 1;
        for (int i : values) {
            lcm = getLcm(lcm, i);
        }
        return lcm;
    }


    //공배수
    static List<Integer> getMultiple(int[] a) {
        int lcm = getLcm(a);
        List<Integer> multiples = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            multiples.add(lcm * i);
        }
        return multiples;
    }

    //공약수
    static HashSet<Integer> getCommonFactor(int b[]) {
        List<Integer> collect = Arrays.stream(b).boxed().collect(Collectors.toList());
        collect.sort((o1, o2) -> 0);
        Integer last = collect.get(collect.size() - 1);
        HashSet<Integer> commonFactor = new HashSet<>();
        for (int i = 1; i <= last; i++) {
            int count = 0;
            int temp = 0;
            for (Integer integer : collect) {
                if (integer % i == 0) {
                    temp = i;
                    count++;
                }
            }

            if (count == collect.size()) {
                commonFactor.add(temp);
            }
        }
        return commonFactor;
    }
}
