package com.eceris.hackerrank.implementation;

import java.util.Scanner;

//    https://www.hackerrank.com/challenges/bon-appetit/problem
public class I4_BonAppetit {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
//        4 1
//        3 10 2 9
//        7
        int number0fFood = scanner.nextInt();
        int declineIdx = scanner.nextInt();
        int arr[] = new int[number0fFood];
        for (int i = 0; i < number0fFood; i++) {
            arr[i] = scanner.nextInt();
        }
        int charged = scanner.nextInt();
        scanner.close();

        int sum = 0;
        for (int i = 0; i < number0fFood; i++) {
            if (i == declineIdx) {
                continue;
            }
            sum += arr[i];
        }
        if (sum / 2 == charged) {
            System.out.println("Bon Appetit");
        } else {
            int recalculated = charged - (sum / 2);
            System.out.println(recalculated);
        }
    }
}
