package kr.co.eceris.algospot.starter;

import java.util.Arrays;
import java.util.List;

/**
 * https://algospot.com/judge/problem/read/FIX
 */
public class Contest {

    public static void main(String[] args) {
        List<Integer> data1 = Arrays.asList(9, 11, 4, 2, 6, 3, 10, 8, 1, 12, 7, 5);
        List<Integer> data2 = Arrays.asList(1, 7, 9, 10, 2, 11, 6, 4, 3, 12, 5, 8);
        System.out.println(getDifficulty(data1));
        System.out.println(getDifficulty(data2));
    }

    public static int getDifficulty(List<Integer> data) {
        int count = 1;
        int result = 0;
        for (Integer value : data) {
            if (count == value) {
                result++;
            }
            count++;
        }
        return result;
    }
}
