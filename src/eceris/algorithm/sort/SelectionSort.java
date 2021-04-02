package eceris.algorithm.sort;

/**
 * Created by PSH on 2017-07-18.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int [] numbers = {9, 12, 1, 3, 6, 2, 8, 4};
        int LENGTH = numbers.length;
        System.out.println("START");
        for (int i = 0; i < LENGTH; i++) {
            int minIndex = i;
            for (int j = i+1 ; j < LENGTH; j++) {
                if (numbers[minIndex] > numbers[j]) {
                	numbers[minIndex] = numbers[j];
                    minIndex = j;
                }
            }
            numbers[minIndex] = numbers[i];
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
