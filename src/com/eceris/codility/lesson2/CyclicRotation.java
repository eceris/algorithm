package com.eceris.codility.lesson2;

import java.util.LinkedList;

public class CyclicRotation {
    public static void main(String[] args) {
        int [] A = new int[]{};
        solution(A, 3);
    }
    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        LinkedList<Integer> q = new LinkedList<>();
        for (int i : A) {
            q.add(i);
        }
        for (int i = 0; i < K ; i++) {
            Integer poll = q.pollLast();
            q.offerFirst(poll);
        }
        if (q.isEmpty()) {
            return A;
        }
        return q.stream().mapToInt(value -> value.intValue()).toArray();
    }
}
