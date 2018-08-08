package com.KwonGusung.codility.Lesson6;

import java.util.Arrays;

public class MaxProductOfThree {

	public static int solution(int[] A) {
		Arrays.sort(A);
		
		int s1 = A[0];
		int s2 = A[1];
		
		int b1 = A[A.length - 1];
		int b2 = A[A.length - 2];
		int b3 = A[A.length - 3];
		
		
		int mmp = s1*s2*b1;
		int ppp = b1*b2*b3;
		
		if(mmp > ppp) {
			return mmp;
		} else {
			return ppp;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {-3, 1, 2, -2, 5, 6};
		//int[] A = {4, 5, 1, 0};
		System.out.println(solution(A));
	}
}
