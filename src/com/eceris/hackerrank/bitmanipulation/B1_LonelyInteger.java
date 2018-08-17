package com.eceris.hackerrank.bitmanipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//    https://www.hackerrank.com/challenges/lonely-integer/problem
public class B1_LonelyInteger {
    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 2, 1};
        int lonelyinteger = lonelyinteger(ints);
        System.out.println(lonelyinteger);
    }

    static int lonelyinteger(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            Integer integer = map.get(i);
            if (integer != null) {
                map.put(i, ++integer);
            } else {
                map.put(i, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 1) {
                return next.getKey();
            }
        }
        return 0;
    }


}
