package com.eceris.algorithm.sort;

/**
 * Created by PSH on 2017-07-17.
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] numbers = {9, 12, 1, 3, 6, 2, 8, 4};

        int LENGTH = numbers.length;
        System.out.println("START");
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 1 ; j < LENGTH; j++) {
                int primary = numbers[j-1];
                int secondary = numbers[j];
                if (secondary < primary) {
                    numbers[j-1] = secondary;
                    numbers[j] = primary;
                }
                print(numbers);
            }
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
