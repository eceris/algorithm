package eceris.codility.lesson3;

import java.util.Arrays;

//      https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
public class PermMissingElem {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 3, 1, 6});
        System.out.println(solution);
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        if (A.length == 0 || A[0] != 1) {
            return 1;
        }

        int startIndex = A[0];
        for (int i = startIndex; i < startIndex + A.length; i++) {
            if (A[i - 1] != i) {
                return i;
            }
        }
        return A[A.length - 1] + 1;
    }
}
