package com.eceris.hackerrank.implementation;

//https://www.hackerrank.com/challenges/apple-and-orange/problem
public class I0_AppleandOrange {
    public static void main(String[] args) {
        int s = 7;  //start
        int t = 11; //end
        int a = 5;  //apple tree
        int b = 15; //orange tree
        int m = 3;  //number of apple
        int n = 2;  //number of orange
        int apples [] = {-2, 2, 1};  //distances that each apple falls from apple tree
        int oranges [] = {5, -6};    //distances that each apple falls from orange tree

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int countOfApples=0;
        int countOfOranges=0;
        for(int apple : apples) {
            if (isInHouse(s, t, a, apple)) {
                countOfApples++;
            }
        }
        for(int orange : oranges) {
            if (isInHouse(s, t, b, orange)) {
                countOfOranges++;
            }
        }
        System.out.println(countOfApples);
        System.out.println(countOfOranges);
    }

    static boolean isInHouse(int startOfHouse, int endOfHouse, int treePosition, int fruitPosition) {
        int realPosition = treePosition + fruitPosition;
        return realPosition >= startOfHouse && realPosition <= endOfHouse;
    }


//    7 11  //start end
//    5 15  //apple true, orange tree
//    3 2   // number of apple, number of orange
//    -2 2 1    //distances that each apple falls from apple tree
//    5 -6      //distances that each apple falls from orange tree
}
