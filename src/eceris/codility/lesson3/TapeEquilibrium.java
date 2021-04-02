package eceris.codility.lesson3;

//  https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

// 순차적인 값들을 특정 인덱스로 나눈 후, 각 양단의 합의 차... (ex, 1,2,3,4 - 5,6,7,8)가 가장 작은 숫자 구하기..
// |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
public class TapeEquilibrium {

    public static void main(String[] args) {
//        int A[] = {3, 1, 2, 4, 3};

//        int[] A = {-1000, 1000};
//        int[] A = {5, 6, 2, 4, 1};
        int[] A = {3, 1, 2, 4, 3};
        int solution = solution(A);
        System.out.println(solution);
    }

    public static int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int startPoint = 1;
        int leftSide = A[0];
        int rightSide = 0;

        int value= 99999;
        for (int i = startPoint; i < A.length; i++) {
            rightSide += A[i];
        }

        for (int i = startPoint; i < A.length; i++) {
            leftSide = leftSide + A[i];
            rightSide= rightSide - A[i];
            int abs = Math.abs(leftSide - rightSide);
            if (value > abs) {
                value =  abs;
            }
        }
        return value;
    }
}
