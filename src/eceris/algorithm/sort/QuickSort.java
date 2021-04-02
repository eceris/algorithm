package eceris.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 퀵 소트
     * 피봇을 기준으로 작은 것은 피봇의 왼쪽 큰 거는 피봇의 오른쪽
     * 한번 정렬 된것에서 왼쪽, 오른쪽을 다시 퀵 소트
     * @param arr
     * @param left
     * @param right
     */
    static void quickSort(int[] arr, int left, int right) {
        if(left < right) {

            int pivotIndex = (left + right) / 2;
            int pivotValue = arr[pivotIndex];

            int lIndex = left;
            int rIndex = right;
            while(lIndex <= rIndex) {

                // pivot 보다 큰것이 나올때 까지 index 구함
                while(arr[lIndex] < pivotValue) {
                    lIndex++;
                }

                // pivot 보다 작은것이 나올때 까지 index 구함
                while(arr[rIndex] > pivotValue) {
                    rIndex--;
                }

                // 왼쪽탐색중 pivot 보다 큰것과 오른쪽 탐색중 pivot 보다 작은것을 서로 교체
                if(lIndex <= rIndex) {
                    swap(arr, lIndex, rIndex);
                    lIndex++;
                    rIndex--;
                }
            }

            if(left < rIndex) {
                quickSort(arr, left, rIndex);
            }
            if(lIndex < right) {
                quickSort(arr, lIndex, right);
            }
        }
    }
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
//        String[] unsorted = {"6", "31415926535897932384626433832795", "1", "3", "10", "3", "5",};
        int[] unsorted = {6, 3145358, 1, 3, 10, 3, 5};
        quickSort(unsorted, 0, unsorted.length - 1);

        Arrays.stream(unsorted).forEach(i -> System.out.println(i));
    }


}
