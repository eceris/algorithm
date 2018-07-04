package com.eceris.algorithm.sort;

/**
 * Created by PSH on 2017-07-20. //http://wkdgusdn3.tistory.com/entry/MergeSort%EB%B3%91%ED%95%A9%EC%A0%95%EB%A0%AC
 */
public class MergeSort {
    public static int[] sorted;

    public static void main(String[] args) {

        int[] numbers = {7, 6, 2, 5, 3, 1, 4};
        int LENGTH = numbers.length;

        sorted = new int[LENGTH];

        System.out.println("START");
        mergeSort(numbers, 0, LENGTH - 1);
        System.out.println("END");
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        if (left == right) { // 탐색 종료
            return;
        }
        int mIndex = (left + right) / 2;
        mergeSort(numbers, left, mIndex);
        mergeSort(numbers, mIndex + 1, right);
        merge(numbers, left, mIndex, right);
    }

    public static void merge(int[] numbers, int left, int mid, int right) {
        int l, m, pointer;

        l = left; //0
        m = mid + 1; //2
        pointer = left; //0
        //right 2

        //노드별 정렬
        while (l <= mid && m <= right) {
            if (numbers[l] <= numbers[m])
                sorted[pointer] = numbers[l++];
            else
                sorted[pointer] = numbers[m++];
            pointer++;
        }

        // 정렬되지 않은 노드들
        if (l > mid) {
            for (int i = m; i <= right; i++) {
                sorted[pointer] = numbers[i];
                pointer++;
            }
        } else {
            for (int i = l; i <= mid; i++) {
                sorted[pointer] = numbers[i];
                pointer++;
            }
        }

        for (int i = left; i <= right; i++) {
            numbers[i] = sorted[i];
        }

        print(numbers);

    }

    public static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }
}
