package eceris.codility.lesson2;

// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int A[] = new int[]{9, 3, 9, 3, 9, 7, 7, 9, 9};
        int solution = solution(A);
        System.out.println(solution);
    }

    // 3, 3, 7, 9, 9, 9, 9
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int value = A[0];
        int count = 0;
        int result = A[A.length -1];
        for (int v : A) {
            if (value == v) {
                count++;
            } else {
                if (count % 2 == 1) {
                    result =  value;
                    break;
                }
                count = 1;
            }
            value = v;
        }
        return result;

//        Arrays.stream(A).forEach(v -> {
//            if (var.get() != v && count % 2 == 1) {
//                var.set(v);
//            }
//        });
    }

    public static int solution1(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(A).forEach(value -> {
            if (Objects.nonNull(map.get(value))) {
                map.remove(value);
            } else {
                map.put(value, 0);
            }
        });
        return map.keySet().stream().findFirst().get();
    }
}
