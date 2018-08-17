package com.eceris.hackerrank.string;
//    https://www.hackerrank.com/challenges/reduced-string/problem

import java.util.Stack;

public class S1_SuperReducedString {
    public static void main(String[] args) {
        String superReducedString = super_reduced_string("aaabccddd");
        System.out.println(superReducedString);
    }

    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        String[] split = s.split("");
        Stack<String> stack = new Stack<>();
        int idx = 0;
        while (idx < split.length) {
            String target = split[idx++];
            if (stack.isEmpty()) {
                stack.push(target);
            } else {
                if (stack.peek().equals(target)) {
                    stack.pop();
                } else {
                    stack.push(target);
                }
            }
        }
        if (stack.isEmpty()) {
            return "Empty String";
        }
        return String.join("", stack);
    }

}
