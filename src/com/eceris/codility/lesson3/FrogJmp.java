package com.eceris.codility.lesson3;

// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
public class FrogJmp {
    public static void main(String[] args) {

        int solution = solution(10, 85, 30);
        System.out.println(solution);
    }

    public static int solution(int X, int Y, int D) {
        int i = (Y - X) / D;
        if ((Y - X) % D == 0) {
            return i;
        }
        return i + 1;
    }



    public static int solution1(int X, int Y, int D) {
        int temp = X;
        int count = 0;
        while(temp <= Y) {
            temp = temp + D;
            count++;
        }
        return count;
    }
}
