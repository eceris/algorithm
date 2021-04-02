package eceris.codility.lesson4;
//  https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

import java.util.Arrays;

//연속되는 숫자인지 체크 하는 문제
public class PermCheck {
    public static void main(String[] args) {
        int A[] = {4, 1, 3, 2};
        int solution = solution(A);
        System.out.println(solution);

    }
    public static int solution(int[] A) {
        Arrays.sort(A);
        int diff= A[1] - A[0];
        int temp = 0;
        for(int i : A) {
            if (temp == 0) {
                temp = i;
                continue;
            }
            if (i - temp != diff) {
                return 0;
            }
            temp = i;
        }
        return 1;
    }


    public static int solution1(int[] A) {
        Arrays.sort(A);
        int temp = -1;
        for (int i : A) {
            if (temp == -1) {
                temp = i;
                continue;
            }
            if (temp != i - 1) {
                return 0;
            }
            temp = i;
        }
        return 1;
    }
}
