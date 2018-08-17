package com.eceris.hackerrank.string;

//    https://www.hackerrank.com/challenges/camelcase/problem
public class S2_CamelCase {
    public static void main(String[] args) {

        String target = "saveChangesInTheEditor";
        int camelcase = camelcase(target);
        System.out.println(camelcase);
    }

    // Complete the camelcase function below.
    static int camelcase(String s) {
        int count = 0;
        if (s.length() > 0) {
            count++;
        }
        for (char c : s.toCharArray()) {
            if (c < 96) {
                count++;
            }
        }
        return count;
    }
}
