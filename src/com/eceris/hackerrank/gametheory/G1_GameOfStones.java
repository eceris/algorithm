package com.eceris.hackerrank.gametheory;
//    https://www.hackerrank.com/challenges/game-of-stones-1/problem
public class G1_GameOfStones {
    public static void main(String[] args) {
        String s = gameOfStones(8);
        System.out.println(s);
    }

    // Complete the gameOfStones function below.
    static String gameOfStones(int n) {
//        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//        S, F, F, F, F, F, S, S, F, F....
        int i = n % 7;
        //남은 수가 2 ~ 6이면 First가 무조건 승리
        if (i > 1 && i < 7) {
            return "First";
        }
        return "Second";
    }
}
