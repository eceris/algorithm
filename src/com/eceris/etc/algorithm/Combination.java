package kr.co.eceris.algorithm;

public class Combination {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int pick = 3;
        int data[] = new int[pick];

        combination(arr, data, 0, arr.length -1, 0, pick);
    }

    public static void combination(int arr[], int temp[], int start, int end, int index, int pick) {
        //r개만큼 모두 뽑은 경우
        if (index == pick) {
            print(temp);
            return;
        }

        for (int i = start; i <= end && end - start + 1 >= pick - index; i++) {
            //원소 1개 고정
            temp[index] = arr[i];
            //재귀
            combination(arr, temp, i + 1, end, index + 1, pick);
        }
    }

    public static void print(int temp[]) {
        for (int i : temp) {
            System.out.print(i);
        }
        System.out.println();
    }
}
