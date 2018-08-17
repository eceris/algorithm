package com.eceris.hackerrank.sorting;

import java.util.Arrays;

//  https://www.hackerrank.com/challenges/big-sorting/problem
public class S1_BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
//        comparator(unsorted);
        return unsorted;
    }

    static void quickSort(String[] arr, int left, int right) {
        if (left < right) {

            int pivotIndex = (left + right) / 2;
            String pivotValue = arr[pivotIndex];

            int lIndex = left;
            int rIndex = right;
            while (lIndex <= rIndex) {

                // pivot 보다 큰것이 나올때 까지 index 구함
                while (isGreaterThanFirst(arr[lIndex], pivotValue)) {
                    lIndex++;
                }

                // pivot 보다 작은것이 나올때 까지 index 구함
                while (isGreaterThanFirst(pivotValue, arr[rIndex])) {
                    rIndex--;
                }

                // 왼쪽탐색중 pivot 보다 큰것과 오른쪽 탐색중 pivot 보다 작은것을 서로 교체
                if (lIndex <= rIndex) {
                    swap(arr, lIndex, rIndex);
                    lIndex++;
                    rIndex--;
                }
            }

            if (left < rIndex) {
                quickSort(arr, left, rIndex);
            }
            if (lIndex < right) {
                quickSort(arr, lIndex, right);
            }
        }
    }

    static void swap(String[] arr, int idx1, int idx2) {
        String temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static boolean isGreaterThanFirst(String o1, String o2) {
//        o2 가 크면 true 아니면 false
        if (o1.length() == o2.length()) {
            boolean b = o2.compareTo(o1) > 0;
            return b;
        }
        return o2.length() - o1.length() > 0;
    }

    static String[] comparator(String[] unsorted) {
        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        return unsorted;
    }

    public static void main(String[] args) {
        String[] unsorted = {"6", "3145358", "1", "3", "10", "3", "5",};
//        String[] unsorted = {"1000", "185268471237394664404712612887434360655188980698758068018366607853573284058797902196156532088814"};

        quickSort(unsorted, 0, unsorted.length - 1);
        System.out.println(String.join(", ", unsorted));
    }



}
