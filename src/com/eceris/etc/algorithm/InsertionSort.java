package kr.co.eceris.algorithm;

/**
 * Created by PSH on 2017-07-19.
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] numbers = {9, 12, 1, 3, 6, 2, 8, 4};

        int LENGTH = numbers.length;
        System.out.println("START");
        for (int i = 1; i < LENGTH; i++) {
            for (int j = i - 1; j > -1; j--) {
                int value = numbers[j + 1];
                if (numbers[j + 1] < numbers[j]) {
                    numbers[j + 1] = numbers[j];
                    numbers[j] = value;
                }else {
                    break;
                }
            }
            print(numbers);
        }
        System.out.println("END");
    }

    public static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }
}
