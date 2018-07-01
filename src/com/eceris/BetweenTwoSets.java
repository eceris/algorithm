package com.eceris;

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

    //공배수
    static List<Integer> getMultiple(int [] a) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = 1; i <= 100 ; i++) {
            int count =0;
            for(int v : a) {
                if (i % v ==0) {
                    count++;
                }
                if (count == a.length) {
                    multiples.add(i);
                }
            }
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
