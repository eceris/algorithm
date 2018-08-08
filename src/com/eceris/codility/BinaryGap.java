package com.eceris.codility;

import java.util.Stack;

//  https://app.codility.com/demo/results/training2X6UM6-2VN/
public class BinaryGap {
    public static Stack<Integer> stack = new Stack<>();
    public static int COUNT = 0;
    public static int MAX = 0;

    public static void main(String[] args) {
        int solution = solution(9);
        System.out.println(solution);
    }

    public static int solution(int N) {
        calc(N);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop == 1) {
                MAX = MAX > COUNT ? MAX : COUNT;
                COUNT = 0;
            } else {
                COUNT++;
            }
        }
        return MAX;
    }

    private static void calc(int N) {
        int value = N / 2;
        int remained = N % 2;
        stack.push(remained);
        if (remained == 1) {
        }
        if (N != 1) {
            solution(value);
        }
        return;
    }
}
