package com.eceris.hackerrank.implementation;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

//https://www.hackerrank.com/challenges/migratory-birds/problem
public class I2_MigratoryBirds {
    public static void main(String[] args) {
        int [] ar = {1, 4, 4, 4, 5, 3};//4
        int i = migratoryBirds(ar);
        System.out.println(i);

    }
    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
        HashMap<Integer, Integer> birdsMap = new HashMap<>();
        AtomicInteger maxBirdType = new AtomicInteger();
        AtomicInteger maxBirdCount = new AtomicInteger(Integer.MIN_VALUE);
        for(int i : ar) {
            Integer count = birdsMap.get(i);
            if (count == null) {
                birdsMap.put(i, 1);
            } else {
                birdsMap.put(i, ++count);
            }
        }

        birdsMap.forEach((k, v) -> {
            if (maxBirdCount.get() < v) {
                maxBirdCount.set(v);
                maxBirdType.set(k);
            }
        });
        return maxBirdType.get();
    }
}
