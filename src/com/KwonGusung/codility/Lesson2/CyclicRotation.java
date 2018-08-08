package com.KwonGusung.codility.Lesson2;

/**
 * https://app.codility.com/c/run/training729PW9-HUK
 * @author create2879
 *
 */
public class CyclicRotation {

	public static int[] solution(int[] A, int K) {
		
		if(A.length == 0 || A.length == 1) {
            return A;
        }
		
		for(int i=0; i<K; i++) {
			int lastNum = A[A.length-1];
			for(int j=A.length-2; j>=0; j--) {
				A[j+1] = A[j];
			}
			A[0] = lastNum;
		}
		return A;
	}
	
	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 6};
		A = solution(A, 3);
		for(int i=0; i<A.length; i++) {
			System.out.println(A[i]);
		}
		System.out.println(solution(A, 3));
		
	}
}
