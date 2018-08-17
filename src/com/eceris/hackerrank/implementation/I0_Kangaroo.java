package com.eceris.hackerrank.implementation;

//https://www.hackerrank.com/challenges/kangaroo/problem
public class I0_Kangaroo {
    public static void main(String[] args) {

//        String kangaroo = kangaroo(1571, 4240, 9023, 4234);
//        String kangaroo = kangaroo(0 ,2 ,5, 3);
        String kangaroo = kangaroo(43, 2, 70, 2);
        System.out.println(kangaroo);
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        while (true) {
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                return "YES";
            }
            if (v1 == v2) {
                return "NO";
            }
            if (x1 > x2 && v1 > v2) {
                return "NO";
            }
            if (x1 < x2 && v1 < v2) {
                return "NO";
            }
        }
    }

}
