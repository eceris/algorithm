package com.eceris;

//https://www.hackerrank.com/challenges/the-birthday-bar/problem

import java.util.Arrays;
import java.util.HashSet;

public class BirthdayChocolate {
    public static HashSet<String> VALUE = new HashSet<>();

    public static void main(String[] args) {
        int[] s = {2, 2, 1, 3, 2}; //2
        int d = 4, m = 2;
        int solve = solve(s, d, m);
        System.out.println(solve);
//        int [] s = {1, 2, 1, 3, 2}; //2
//        int d = 3, m = 2;
//
//        int [] s = {1, 1, 1, 1, 1, 1}; //0
//        int d = 3, m = 2;
//
//        int [] s = {4}; //1
//        int d = 4, m = 1;
    }

    // Complete the solve function below.
    static int solve(int[] s, int d, int m) {
        int data[] = new int[m];
        combination(s, data, 0, s.length - 1, 0, m, d);
        return VALUE.size();
    }


    /**
     * @param arr   원소들
     * @param temp  뽑힌 원소
     * @param start 원소 탐색 시작지점
     * @param end   원소 탐색 종료지점
     * @param index 현재 뽑은 갯수
     * @param pick  뽑아야할 갯수
     */
//    static void combination(int arr[]/*원소들*/, int temp[]/*뽑힌원소*/, int start/*시작지점*/, int end/*종료지점*/, int index/*현재뽑은갯수*/, int pick/*뽑아야할갯수*/) {
    static void combination(int arr[], int temp[], int start, int end, int index, int pick, int day) {
        //r개만큼 모두 뽑은 경우
        if (index == pick) {
            int value = Arrays.stream(temp).reduce((a, b) -> a + b).getAsInt();
            if (value == day) {
                VALUE.add(addSet(temp));
            }
//            print(temp);
            return;
        }

        for (int i = start; i <= end && end - start + 1 >= pick - index; i++) {
            //원소 1개 고정
            temp[index] = arr[i];
            //재귀
            combination(arr, temp, i + 1, end, index + 1, pick, day);
        }
    }

    static String addSet(int temp[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : temp) {
            sb.append(i);
        }
        return sb.toString();
    }

    static void print(int temp[]) {
        for (int i : temp) {
            System.out.print(i);
        }
        System.out.println();
    }

}
