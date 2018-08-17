package com.eceris.hackerrank.sorting;
//    https://www.hackerrank.com/challenges/tutorial-intro/problem
public class S2_TutorialIntro {
    public static void main(String[] args) {
        int V = 4;
        int [] arr = {1, 4, 5, 7, 9, 12};
        int i = introTutorial(V, arr);
        System.out.println(i);
    }
    static int introTutorial(int V, int[] arr) {
        for(int i=0; i< arr.length; i++) {
            if (arr[i] == V) return i;
        }
        return -1;
    }
}
